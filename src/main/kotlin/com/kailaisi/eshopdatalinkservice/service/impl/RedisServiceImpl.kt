package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.service.RedisService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class RedisServiceImpl : RedisService {
    @Autowired
    private lateinit var stringRedisTemplate: StringRedisTemplate

    override fun set(key: String, value: String) {

        stringRedisTemplate.opsForValue().set(key, value)
    }

    override fun get(key: String): String? {
        return stringRedisTemplate.opsForValue().get(key)
    }

    override fun remove(key: String) {
        stringRedisTemplate.delete(key)
    }

    override fun expire(key: String, expire: Long) {
        stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS)
    }

    override fun increment(key: String, delta: Long): Long? {
        return stringRedisTemplate.opsForValue().increment(key, delta)
    }

}