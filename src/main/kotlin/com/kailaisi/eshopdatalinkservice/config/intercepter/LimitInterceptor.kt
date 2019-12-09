package com.kailaisi.eshopdatalinkservice.config.intercepter

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.service.RateLimitService
import com.kailaisi.eshopdatalinkservice.service.RedisService
import com.kailaisi.eshopdatalinkservice.util.IPUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
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
    @Qualifier("getRedisScript")
    @Resource
    lateinit var ratelimitLua: RedisScript<Long>
    @Qualifier("getInitRedisScript")
    @Resource
    lateinit var ratelimitInitLua: RedisScript<Long>

    @Autowired
    lateinit var stringRedisTemplate: StringRedisTemplate

    @Autowired
    lateinit var redisService: RedisService

    @Autowired
    lateinit var rateLimitService: RateLimitService

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        //获取限流信息
        var ip = IPUtils.getRealIp(request)!!
        var uri = request.requestURI
        loadLimit(ip,uri)
        return true
    }

    /**
     * 获取限流信息
     * 1.从redis获取,如果为-1，则不限流
     * 2.如果redis没有，则从mysql获取
     * 3.如果mysql也没有，则配置redis对应的为-1,表示不进行限流
     */
    private fun loadLimit(ip: String, uri: String) {
        var key = getKey(uri)
        /**
        -- KEYS[1]  string  限流的key

        -- ARGV[1]  int     桶最大容量
        -- ARGV[2]  int     每次添加令牌数
        -- ARGV[3]  int     令牌添加间隔(秒)
        -- ARGV[4]  int     当前时间戳
         */
        var hasLimit = redisService.get(key)
        var max: Int = -1
        var limit: Int = -1
        if (hasLimit == null) {
            val bean = rateLimitService.selectByName(uri)
            if (bean != null) {
                redisService.set(key, bean.limit.toString())
                max = bean.max
                limit = bean.limit
            }else{
                redisService.set(key,"-1")
            }
        }else{
            redisService
        }
        var execute = stringRedisTemplate.execute(ratelimitInitLua, Collections.singletonList(key), max.toString(), limit.toString(), 1.toString(), 0.toString())
        if (execute == 1L || execute == 0L) {
            return
        } else {
            throw BusinessException("请勿频繁操作")
        }
    }

    private fun getKey(uri: String): String {
        return "ratelimit_${uri}"
    }
}