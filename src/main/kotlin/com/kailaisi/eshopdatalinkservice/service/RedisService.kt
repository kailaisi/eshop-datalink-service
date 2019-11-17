package com.kailaisi.eshopdatalinkservice.service

/**
 *描述：redis的基本实现
 *<p/>作者：wu
 *<br/>创建时间：2019/11/16 16:53
 */
interface RedisService {
    fun set(key: String, value: String)

    fun get(key: String): String?

    fun remove(key: String)
    /**
     * 设置超期时间
     */
    fun expire(key: String, expire: Long)

    /**
     * 自增操作
     */
    fun increment(key: String, delta: Long): Long?
}