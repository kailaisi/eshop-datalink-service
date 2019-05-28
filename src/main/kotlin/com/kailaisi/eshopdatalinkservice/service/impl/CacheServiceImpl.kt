package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.service.CacheService
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class CacheServiceImpl : CacheService {
    @CachePut(value = ["local"], key = "'key'+#id")
    override fun putProductInfo(id: Long, info: String) = info


    @Cacheable(value = ["local"], key = "'key'+#id")
    override fun getProductInfo(id: Long): String? = null
}