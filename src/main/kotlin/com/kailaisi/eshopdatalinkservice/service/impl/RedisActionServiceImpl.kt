package com.kailaisi.eshopdatalinkservice.service.impl

import cn.hutool.json.JSONUtil
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.service.RedisActionService
import com.kailaisi.eshopdatalinkservice.service.RedisService
import com.kailaisi.eshopdatalinkservice.util.HongBaoCreateUtil
import com.kailaisi.eshopdatalinkservice.util.LoginTokenHelper
import com.kailaisi.eshopdatalinkservice.util.logger
import org.apache.commons.io.FileUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.core.script.RedisScript
import org.springframework.stereotype.Service
import redis.clients.jedis.Jedis
import java.io.File
import javax.annotation.Resource

@Service
class RedisActionServiceImpl : RedisActionService {
    val log = logger(this)
    @Autowired
    lateinit var redisService: RedisService
    @Autowired
    lateinit var jedis: Jedis
    @Qualifier("gethongbaoInitLua")
    @Resource
    lateinit var gethongbaoInitLua: RedisScript<String?>
    @Autowired
    lateinit var stringRedisTemplate: StringRedisTemplate

    override fun create(size: Int, total: Long): String {
        if (size > total) {
            throw BusinessException("红包数不能大于总金额")
        }
        var loginUser = LoginTokenHelper.loginUserFromRequest
        if (loginUser == null) {
            throw BusinessException("请先登录")
        }
        var longs = HongBaoCreateUtil.generate(total, size, total - size, 1)
        var key = "hongbao_${loginUser.id}_${System.currentTimeMillis()}"
        redisService.lpush(key, longs.map { it }.toTypedArray())
        //todo 增加死信队列，24小时候将红包返回，然后将红包redis删除
        return key
    }

    override fun rob(id: String): String {
        var loginUser = LoginTokenHelper.loginUserFromRequest
        if (loginUser == null) {
            throw BusinessException("请先登录")
        }
        val userId = loginUser.id
        var master = id.split("_")
        var list = listOf(id, "robed_${master[1]}_${master[2]}", "robeduser_${master[1]}_${master[2]}", userId.toString(), userId.toString())
        /*  todo  不知道为什么注释代码为何不行，需要确认
        var execute = stringRedisTemplate.execute(gethongbaoInitLua, Collections.singletonList(userId.toString()),id, "robed_${master[1]}_${master[2]}", "robeduser_${master[1]}_${master[2]}", userId.toString(),userId.toString())
        if(execute!=null){
            return execute.toString()
        }else{
            //如果抢完了，将死信队列id删除掉
            throw BusinessException("未抢到红包")
        }*/
        val path = jedis.javaClass.getResource("/").path + "/lua/gethongbao.lua"
        val s: String = FileUtils.readFileToString(File(path), "utf-8")
        val eval = jedis.eval(s, 1, userId.toString(), id, "robed_${master[1]}_${master[2]}", "robeduser_${master[1]}_${master[2]}")
        if (eval == null) {
            throw BusinessException("您已经抢过红包了哦。")
        } else {
            log.info(eval.toString())
            var hashMap = JSONUtil.parseObj(eval.toString())
            if (hashMap.get("money") == null) {
                throw BusinessException("红包一抢完.")
            }
            return hashMap.get("money").toString()
        }
    }
}