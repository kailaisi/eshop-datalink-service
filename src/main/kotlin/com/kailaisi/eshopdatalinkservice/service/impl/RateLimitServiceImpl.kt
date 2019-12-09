package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.mgb.mapper.RateLimitMapper
import com.kailaisi.eshopdatalinkservice.mgb.model.RateLimit
import com.kailaisi.eshopdatalinkservice.service.RateLimitService
import com.kailaisi.eshopdatalinkservice.service.commonservice.MySqlCrudServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * 限流信息表
 */
@Service
class RateLimitServiceImpl : MySqlCrudServiceImpl<RateLimit, Int>(), RateLimitService {
    @Autowired
    lateinit var rateLimitMapper: RateLimitMapper
    override fun selectByName(uri: String): RateLimit? {
        return rateLimitMapper.selectByName(uri)
    }
}