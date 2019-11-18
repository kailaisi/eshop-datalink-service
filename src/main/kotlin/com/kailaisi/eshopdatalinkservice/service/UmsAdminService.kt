package com.kailaisi.eshopdatalinkservice.service

import com.kailaisi.eshopdatalinkservice.mgb.model.UmsAdmin
import com.kailaisi.eshopdatalinkservice.service.commonservice.CrudService

interface UmsAdminService : CrudService<UmsAdmin, Long> {
    fun getAdminByUserName(it: String): List<UmsAdmin>?
}
