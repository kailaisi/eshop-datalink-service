package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.model.LoginToken
import com.kailaisi.eshopdatalinkservice.model.enums.CacheKeyEnum
import com.kailaisi.eshopdatalinkservice.service.LoginTokenService
import com.kailaisi.eshopdatalinkservice.util.LoginTokenHelper
import com.kailaisi.eshopdatalinkservice.util.logger
import lombok.extern.slf4j.Slf4j
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.util.Assert
import java.util.concurrent.TimeUnit

@Slf4j
class LoginTokenCacheServiceImpl(loginTokenTemplate: RedisTemplate<String, LoginToken>, loginTokenCacheKeyPrefix: String) : LoginTokenService {
    val log= logger(this)
    private val loginTokenValueOps: ValueOperations<String, LoginToken>
    private val loginTokenTemplate: RedisTemplate<String, LoginToken>
    private val loginTokenCacheKeyPrefix: String
    private fun getLoginTokenCacheKey(token: String): String {
        val key = loginTokenCacheKeyPrefix + token
        return key
    }

    override fun add(loginToken: LoginToken): LoginToken {
        Assert.notNull(loginToken, "loginToken is not null")
        Assert.notNull(loginToken.loginUser, "loginToken.getLoginUser() is not null")
        val token = LoginTokenHelper.generateToken(loginToken)
        loginToken.id = token
        loginTokenValueOps.set(getLoginTokenCacheKey(loginToken.id), loginToken,CacheKeyEnum.VALUE_LOGIN_TOKENS.sec.toLong(),TimeUnit.SECONDS)
        return loginToken
    }

    override fun deleteById(id: String) {
        Assert.notNull(id, "id is not null")
        loginTokenTemplate.delete(getLoginTokenCacheKey(id))
    }

    override fun getById(id: String): LoginToken? {
        Assert.notNull(id, "id is not null")
        return loginTokenValueOps[getLoginTokenCacheKey(id)]
    }

    override fun ttl(id: String): Long {
        Assert.notNull(id, "id is not null")
        return loginTokenTemplate.getExpire(getLoginTokenCacheKey(id), TimeUnit.SECONDS)
    }

    override fun expire(token: String?) {
        Assert.notNull(token, "token is not null")
        loginTokenTemplate.expire(getLoginTokenCacheKey(token!!),CacheKeyEnum.VALUE_LOGIN_TOKENS.sec.toLong(),TimeUnit.SECONDS)
    }

    init {
        Assert.notNull(loginTokenTemplate, "loginTokenTemplate is not null.")
        Assert.notNull(loginTokenCacheKeyPrefix, "loginTokenCacheKeyPrefix is not null.")
        this.loginTokenTemplate = loginTokenTemplate
        this.loginTokenCacheKeyPrefix = loginTokenCacheKeyPrefix
        loginTokenValueOps = loginTokenTemplate.opsForValue()
    }
}