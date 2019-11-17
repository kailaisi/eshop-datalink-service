package com.kailaisi.eshopdatalinkservice.control

import com.kailaisi.eshopdatalinkservice.config.intercepter.LoginAuth
import com.kailaisi.eshopdatalinkservice.model.LoginQO
import com.kailaisi.eshopdatalinkservice.model.LoginUser
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResponseResult
import com.kailaisi.eshopdatalinkservice.service.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *描述：用户信息接口
 *<p/>作者：wu
 *<br/>创建时间：2019/11/7 11:31
 */
@ResponseResult
@RestController
@RequestMapping("/user")
class LoginController {
    @Autowired
    lateinit var loginService: LoginService

    @RequestMapping("/login")
    fun login(@RequestBody loginQO: LoginQO) {
        loginService.login(loginQO)
    }

    @RequestMapping("/logout")
    fun logout() {
        loginService.logout()
    }

    @LoginAuth
    @GetMapping("/profile")
    fun myAccount(loginUser: LoginUser?): LoginUser? {
        return loginUser
    }
}