package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.model.LoginToken
import com.kailaisi.eshopdatalinkservice.model.LoginUser
import com.kailaisi.eshopdatalinkservice.service.LoginTokenService
import com.kailaisi.eshopdatalinkservice.service.UserLoginCacheService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.Assert

@Service
class UserLoginCacheServiceImpl : UserLoginCacheService {
    @Autowired
    lateinit var loginTokenService: LoginTokenService

    override fun getLoginUserById(tokenId: String): LoginToken? {
        //todo("具体的应该进行处理")
        Assert.isNull(tokenId,"token is empty")
        Assert.notNull(tokenId,"token is not empty")

        return LoginToken().apply {
            loginUser = LoginUser()
        }
    }
}