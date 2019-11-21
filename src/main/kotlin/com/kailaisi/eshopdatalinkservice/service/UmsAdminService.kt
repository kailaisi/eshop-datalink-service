package com.kailaisi.eshopdatalinkservice.service

import com.kailaisi.eshopdatalinkservice.mgb.model.UmsAdmin
import com.kailaisi.eshopdatalinkservice.model.LoginQO
import com.kailaisi.eshopdatalinkservice.model.qo.UmsAdminRegisterQO
import com.kailaisi.eshopdatalinkservice.service.commonservice.CrudService

interface UmsAdminService : CrudService<UmsAdmin, Long> {
    fun getAdminByUserName(it: String): List<UmsAdmin>?
    fun login(loginQO: LoginQO): String
    fun logout()
    /**
     * 注册
     */
    fun register(umsAdminQO: UmsAdminRegisterQO)
}
