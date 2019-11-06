package com.kailaisi.eshopdatalinkservice.service

import com.kailaisi.eshopdatalinkservice.data.LoginToken

/**
 *描述：登录用户Service
 *<p/>作者：wu
 *<br/>创建时间：2019/11/6 11:35
 */
interface UserLoginCacheService {
    fun getLoginUserById(tokenId: String): LoginToken?
}