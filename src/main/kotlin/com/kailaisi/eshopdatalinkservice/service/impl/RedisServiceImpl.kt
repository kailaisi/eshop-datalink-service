package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.service.RedisService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class RedisServiceImpl : RedisService {
    @Autowired
    private lateinit var stringRedisTemplate: StringRedisTemplate
    @Autowired
    lateinit var redisTemplate: RedisTemplate<String, Any>

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

    override fun hset(key: String, field: String, value: Any) {
        redisTemplate.opsForHash<String, Any>().put(key, field, value)
    }

    override fun hmset(key: String, hash: HashMap<String, Any>) {
        redisTemplate.opsForHash<String, Any>().putAll(key, hash)
    }

    override fun hget(key: String, field: String): Any? {
        return redisTemplate.opsForHash<String, String>().get(key, field)
    }

    override fun hdel(key: String, field: String) {
    }

    override fun hmget(key: String): MutableMap<String, Any> {
        return stringRedisTemplate.opsForHash<String, Any>().entries(key)
    }

    override fun hincr(key: String, field: String) {
        redisTemplate.opsForHash<String, Any>().increment(key, field, 1)
    }

    override fun exist(key: String): Boolean {
      return  redisTemplate.hasKey(key)
    }
}