package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.service.RedisService
import com.kailaisi.eshopdatalinkservice.service.UmsMemberService
import org.apache.commons.lang.math.RandomUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/11/17 0:42
 */
@Service
class UmsMemberServiceImpl : UmsMemberService {

    @Autowired
    lateinit var redisService: RedisService

    @Value("\${redis.key.prefix.authCode}")
    lateinit var REDIS_KEY_PREFIX_AUTH_CODE: String

    @Value("\${redis.key.expire.authCode}")
    var AUTH_CODE_EXPIRE_SECONDS: Long = 0

    override fun generateAuthCode(phone: String): String {
        var builder = StringBuilder()
        for (i in 0..6) {
            builder.append(RandomUtils.nextInt(10))
        }
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + phone, builder.toString())
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + phone, AUTH_CODE_EXPIRE_SECONDS)
        return builder.toString()
    }

    override fun verifyAuthCode(phone: String, authCode: String?): String {
        if (authCode.isNullOrBlank()) {
            throw BusinessException("请输入校验码")
        }
        val realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + phone)
        val result = authCode.equals(realAuthCode)
        return if (result) {
            return "验证码校验成功"
        } else {
            throw BusinessException("验证码不正确")
        }
    }

}