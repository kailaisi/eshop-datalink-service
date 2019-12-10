package com.kailaisi.eshopdatalinkservice.config.intercepter

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.service.RateLimitService
import com.kailaisi.eshopdatalinkservice.service.RedisService
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
class RequestLimitInterceptor : HandlerInterceptor {
    @Qualifier("getRedisScript")
    @Resource
    lateinit var requestratelimit: RedisScript<Long>

    @Autowired
    lateinit var stringRedisTemplate: StringRedisTemplate
    /**
     * redis操作类
     */
    @Autowired
    lateinit var redisService: RedisService
    /**
     * 限流sql数据库查询
     */
    @Autowired
    lateinit var rateLimitService: RateLimitService

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        /**
         * 获取限流信息
         * 1.从redis获取,如果为-1，则不限流
         * 2.如果redis没有，则从mysql获取
         * 3.如果mysql也没有，则配置redis对应的为-1,表示不进行限流
         */
        val uri = request.requestURI
        var key = getKey(uri)
        /**
        -- KEYS[1]  string  限流的key
        -- ARGV[1],   请求的令牌数
        -- "last_mill_second",ARGV[2],   当前时间戳
         */
        val hasLimit = redisService.exist(key)
        val currMillSecond = stringRedisTemplate.execute { redisConnection -> redisConnection.time() }
        if (hasLimit) {
            val bean = rateLimitService.selectByName(uri)
            val map = hashMapOf<String, Any>()
            if (bean != null) {
                map["curr_permits"] = bean.limit
                map["max_burst"] = bean.max
                map["rate"] = bean.limit
                map["app"] = "1"
                redisService.hmset(key, map)
            } else {
                map["rate"] = 0
                redisService.hmset(key, map)
            }
            redisService.expire(key, 7 * 60 * 60 * 24)
        }
        val execute = stringRedisTemplate.execute(requestratelimit, Collections.singletonList(key), 1.toString(), currMillSecond.toString())
        if (execute == 1L || execute == 0L) {
            return true
        } else {
            throw BusinessException("请勿频繁操作")
        }
    }

    private fun getKey(uri: String): String {
        return "request_limit_${uri}"
    }
}