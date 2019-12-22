package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.config.intercepter.BoomFilter
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResultCode
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.mgb.mapper.UmsAdminMapper
import com.kailaisi.eshopdatalinkservice.mgb.model.UmsAdmin
import com.kailaisi.eshopdatalinkservice.model.HeaderConstants
import com.kailaisi.eshopdatalinkservice.model.LoginQO
import com.kailaisi.eshopdatalinkservice.model.LoginToken
import com.kailaisi.eshopdatalinkservice.model.LoginUser
import com.kailaisi.eshopdatalinkservice.model.enums.CacheKeyEnum
import com.kailaisi.eshopdatalinkservice.model.qo.UmsAdminRegisterQO
import com.kailaisi.eshopdatalinkservice.service.LoginTokenService
import com.kailaisi.eshopdatalinkservice.service.UmsAdminService
import com.kailaisi.eshopdatalinkservice.service.commonservice.MySqlCrudServiceImpl
import com.kailaisi.eshopdatalinkservice.util.IPUtils
import com.kailaisi.eshopdatalinkservice.util.LoginTokenHelper
import com.kailaisi.eshopdatalinkservice.util.RequestContextHolderUtil
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

/**
 *描述：用户权限
 *<p/>作者：wu
 *<br/>创建时间：2019/11/18 15:06
 */
@Service
class UmsAdminServiceImpl : MySqlCrudServiceImpl<UmsAdmin, Long>(), UmsAdminService {
    @Autowired
    lateinit var mapper: UmsAdminMapper
    @Autowired
    lateinit var passwordEncoder: PasswordEncoder
    @Autowired
    lateinit var loginTokenService: LoginTokenService
    @Autowired
    lateinit var boomFilter: BoomFilter

    override fun getAdminByUserName(it: String): List<UmsAdmin>? {
        return mapper.getAdminByUserName(it)
    }

    override fun register(umsAdminQO: UmsAdminRegisterQO) {
        val list = mapper.getAdminByUserName(umsAdminQO.username)
        if (list.size > 0) {
            throw  BusinessException(ResultCode.USER_HAS_EXISTED)
        }
        val umsAdmin = UmsAdmin()
        BeanUtils.copyProperties(umsAdminQO, umsAdmin)
        umsAdmin.password = passwordEncoder.encode(umsAdminQO.password)
        mapper.insert(umsAdmin)
    }

    override fun login(loginQO: LoginQO): String {
        if(!boomFilter.contains(loginQO.username)){
            throw BusinessException(ResultCode.USER_LOGIN_ERROR)
        }
        val list = mapper.getAdminByUserName(loginQO.username)
        if (list.size == 0) {
            throw BusinessException(ResultCode.USER_LOGIN_ERROR)
        }
        val umsAdmin = list[0]
        if (!passwordEncoder.matches(loginQO.pwd, umsAdmin.password)) {
            throw BusinessException(ResultCode.USER_LOGIN_ERROR)
        }
        val request = RequestContextHolderUtil.request
        val user = LoginUser()
        BeanUtils.copyProperties(umsAdmin, user)
        var tokenInfo = LoginToken().apply {
            createTime = Date()
            ip = IPUtils.getRealIp(request)
            platform = request.getHeader(HeaderConstants.CALL_SOURCE)
            loginUser = user
        }
        tokenInfo = loginTokenService.add(tokenInfo)
        LoginTokenHelper.addLoginTokenIdToCookie(tokenInfo.id, CacheKeyEnum.VALUE_LOGIN_TOKENS.sec)
        return tokenInfo.id
    }

    override fun logout() {
        val loginToken: LoginToken = LoginTokenHelper.getLoginTokenFromRequest()
                ?: throw BusinessException(ResultCode.USER_NOT_LOGGED_IN)
        loginTokenService.deleteById(loginToken.id)
        LoginTokenHelper.delLoginTokenIdFromCookie()
    }


}