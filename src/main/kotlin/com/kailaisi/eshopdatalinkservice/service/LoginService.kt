package com.kailaisi.eshopdatalinkservice.service

import com.kailaisi.eshopdatalinkservice.data.LoginQO
import org.springframework.stereotype.Service

/**
 *描述：登录服务Service
 *<p/>作者：wu
 *<br/>创建时间：2019/11/6 11:35
 */
interface LoginService {
    fun login(loginQO: LoginQO)
    fun logout()
}