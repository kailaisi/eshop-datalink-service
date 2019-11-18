package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.mgb.mapper.UmsAdminMapper
import com.kailaisi.eshopdatalinkservice.mgb.model.UmsAdmin
import com.kailaisi.eshopdatalinkservice.service.UmsAdminService
import com.kailaisi.eshopdatalinkservice.service.commonservice.MySqlCrudServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *描述：用户权限
 *<p/>作者：wu
 *<br/>创建时间：2019/11/18 15:06
 */
@Service
class UmsAdminServiceImpl : MySqlCrudServiceImpl<UmsAdmin, Long>(), UmsAdminService {
    @Autowired
    lateinit var mapper: UmsAdminMapper

    override fun getAdminByUserName(it: String): List<UmsAdmin>? {
        return mapper.getAdminByUserName(it)
    }
}