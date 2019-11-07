package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.data.LoginToken
import com.kailaisi.eshopdatalinkservice.data.LoginUser
import com.kailaisi.eshopdatalinkservice.service.UserLoginCacheService
import org.springframework.stereotype.Service

@Service
class UserLoginCacheServiceImpl : UserLoginCacheService {
    override fun getLoginUserById(tokenId: String): LoginToken? {
        //todo("具体的应该进行处理")
        return LoginToken().apply {
            loginUser = LoginUser()
        }
    }
}