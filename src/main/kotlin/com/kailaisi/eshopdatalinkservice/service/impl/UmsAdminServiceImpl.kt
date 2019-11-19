package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResultCode
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.mgb.mapper.UmsAdminMapper
import com.kailaisi.eshopdatalinkservice.mgb.model.UmsAdmin
import com.kailaisi.eshopdatalinkservice.model.LoginQO
import com.kailaisi.eshopdatalinkservice.model.qo.UmsAdminRegisterQO
import com.kailaisi.eshopdatalinkservice.service.UmsAdminService
import com.kailaisi.eshopdatalinkservice.service.commonservice.MySqlCrudServiceImpl
import org.springframework.beans.BeanUtils
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

    override fun register(umsAdminQO: UmsAdminRegisterQO) {
        var list = mapper.getAdminByUserName(umsAdminQO.username)
        if (list.size > 0) {
            throw  BusinessException(ResultCode.USER_HAS_EXISTED)
        }
        val umsAdmin = UmsAdmin()
        BeanUtils.copyProperties(umsAdminQO, umsAdmin)
    }

    override fun login(loginQO: LoginQO) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun logout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}