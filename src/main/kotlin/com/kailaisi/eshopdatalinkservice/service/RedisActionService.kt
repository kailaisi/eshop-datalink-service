package com.kailaisi.eshopdatalinkservice.service

interface RedisActionService {
    fun create(size: Int, total: Long): String
    fun rob(id: String): String
}
