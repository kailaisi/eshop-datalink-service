package com.kailaisi.eshopdatalinkservice.util

import org.springframework.stereotype.Component
import redis.clients.jedis.Jedis
import redis.clients.jedis.JedisPool
import java.util.*

/**
 *描述：基于Redis的分布式锁
 *<p/>作者：wu
 *<br/>创建时间：2019/12/30 23:01
 */
@Component
class RedisLock {
    lateinit var jedisPool: JedisPool

    fun lockWithTimeout(key: String, acquireTimeout: Long, timeout: Long): String? {
        var jedis: Jedis? = null
        var uuid: String? = null
        try {
            jedis = jedisPool.resource
            uuid = UUID.randomUUID().toString()
            val lockKey = "lock:$key"
            val end = System.currentTimeMillis() + acquireTimeout
            while (System.currentTimeMillis() < end) {
                if (jedis.setnx(lockKey, uuid) == 1L) {
                    //加锁成功了
                    jedis.expire(lockKey, timeout.toInt())
                    return uuid
                }
                //执行到此处，证明此线程之前获取到了锁，但是已经到期，那么续期，实现重入锁
                if (jedis.ttl(lockKey) == -1L) {
                    //如果原来的
                    jedis.expire(lockKey, timeout.toInt())
                }
                try {
                    //休眠，避免出现活锁
                    Thread.sleep(10)
                } catch (e: Exception) {

                }
            }
        } catch (e: Exception) {
        } finally {
            jedis?.close()
        }
        return uuid
    }

    /**
     * 释放锁
     */
    fun releaseLock(key: String, uuid: String): Boolean {
        var jedis: Jedis? = null
        val lockKey = "lock:$key"
        var retFlag = false
        try {
            jedis = jedisPool.resource
            while (true) {
                // 开启watch之后，如果key所对应的value值被修改，则事务失败，exec方法返回null
                jedis.watch(lockKey)
                // 通过前面返回的value值判断是不是该锁，若是该锁，则删除，释放锁
                if (uuid == jedis.get(lockKey)) {
                    val transaction = jedis.multi()
                    transaction.del(lockKey)
                    var results = transaction.exec()
                    if (results == null) {
                        continue
                    }
                    retFlag = true
                }
                jedis.unwatch()
                break
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        } finally {
            jedis?.close()
        }
        return retFlag
    }
}