package com.kailaisi.eshopdatalinkservice.service

import com.kailaisi.eshopdatalinkservice.mgb.model.RateLimit
import com.kailaisi.eshopdatalinkservice.mgb.model.UmsAdmin
import com.kailaisi.eshopdatalinkservice.service.commonservice.CrudService

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/12/9 21:43
 */
interface RateLimitService: CrudService<RateLimit, Int> {
    fun selectByName(uri: String):RateLimit?
}