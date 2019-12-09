package com.kailaisi.eshopdatalinkservice.config.intercepter

import com.kailaisi.eshopdatalinkservice.service.InterfaceLimitService
import com.kailaisi.eshopdatalinkservice.util.IPUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.connection.RedisConnection
import org.springframework.data.redis.core.RedisCallback
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.core.script.RedisScript
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 *描述：限制接口的访问
 *<p/>作者：wu
 *<br/>创建时间：2019/12/9 17:14
 */
@Component
class LimitInterceptor : HandlerInterceptor {
    @Autowired
    lateinit var stringRedisTemplate: StringRedisTemplate
    @Qualifier("getRedisScript")
    @Resource
    lateinit var ratelimitLua: RedisScript<Long>
    @Qualifier("getInitRedisScript")
    @Resource
    lateinit var ratelimitInitLua: RedisScript<Long>

    @Autowired
    lateinit var interfaceLimitService: InterfaceLimitService

    val currMillSecond = stringRedisTemplate.execute { redisConnection -> redisConnection.time() }

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        return super.preHandle(request, response, handler)
        //todo 有待完善
        //获取限流信息
        var ip = IPUtils.getRealIp(request)
        var uri = request.requestURI
        loadLimit(uri)

    }

    /**
     * 获取限流信息
     * 1.从redis获取,如果为-1，则不限流
     * 2.如果redis没有，则从mysql获取
     * 3.如果mysql也没有，则配置redis对应的为-1,表示不进行限流
     */
    private fun loadLimit(uri: String) {
        var map = interfaceLimitService.getCount("${uri}_limit")
        /**
         * redis.pcall("HMSET",KEYS[1],
        "last_mill_second",ARGV[1],
        "curr_permits",ARGV[2],
        "max_burst",ARGV[3],
        "rate",ARGV[4],
        "app",ARGV[5])
         */
        var execute = stringRedisTemplate.execute(ratelimitInitLua, Collections.singletonList(getKey(uri)), currMillSecond.toString(), "1", "10", "10", "skynet")
        if(execute==1L || execute==0L){
            return
        }else{

        }
    }

    private fun getKey(key: String): String {
        return ""
    }
}