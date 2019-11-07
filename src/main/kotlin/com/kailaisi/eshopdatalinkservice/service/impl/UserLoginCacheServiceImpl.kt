package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.data.LoginToken
import com.kailaisi.eshopdatalinkservice.data.LoginUser
import com.kailaisi.eshopdatalinkservice.service.UserLoginCacheService
import org.springframework.stereotype.Service
import org.springframework.util.Assert

@Service
class UserLoginCacheServiceImpl : UserLoginCacheService {
    override fun getLoginUserById(tokenId: String): LoginToken? {
        //todo("具体的应该进行处理")
        Assert.isNull(tokenId,"token is empty")
        Assert.notNull(tokenId,"token is not empty")
        return LoginToken().apply {
            loginUser = LoginUser()
        }
    }
}