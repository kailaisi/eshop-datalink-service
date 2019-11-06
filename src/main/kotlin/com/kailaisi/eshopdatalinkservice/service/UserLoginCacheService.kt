package com.kailaisi.eshopdatalinkservice.service

import com.kailaisi.eshopdatalinkservice.data.LoginToken
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service

/**
 *描述：登录用户Service
 *<p/>作者：wu
 *<br/>创建时间：2019/11/6 11:35
 */
@Service
@Slf4j
interface UserLoginCacheService {
    fun getLoginUserById(tokenId: String): LoginToken?
}