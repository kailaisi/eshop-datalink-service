package com.kailaisi.eshopdatalinkservice.control

import com.kailaisi.eshopdatalinkservice.config.intercepter.LoginAuth
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResponseResult
import com.kailaisi.eshopdatalinkservice.model.LoginQO
import com.kailaisi.eshopdatalinkservice.model.LoginUser
import com.kailaisi.eshopdatalinkservice.model.qo.UmsAdminRegisterQO
import com.kailaisi.eshopdatalinkservice.service.UmsAdminService
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 *描述：用户信息接口
 *<p/>作者：wu
 *<br/>创建时间：2019/11/7 11:31
 */
@ResponseResult
@RestController
@RequestMapping("/admin")
class UmsAdminController {
    @Autowired
    lateinit var umsAdminService:  UmsAdminService

    @PostMapping("/register")
    @ApiOperation("用户注册")
    fun register(@RequestBody umsAdminQO: UmsAdminRegisterQO){
        umsAdminService.register(umsAdminQO)
    }

    @RequestMapping("/login")
    fun login(@RequestBody loginQO: LoginQO) {
        umsAdminService.login(loginQO)
    }

    @RequestMapping("/logout")
    fun logout() {
        umsAdminService.logout()
    }

    @LoginAuth
    @GetMapping("/profile")
    fun myAccount(loginUser: LoginUser?): LoginUser? {
        return loginUser
    }
}