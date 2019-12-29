package com.kailaisi.eshopdatalinkservice.control

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResponseResult
import com.kailaisi.eshopdatalinkservice.service.UmsMemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 *描述：会员的登录注册
 *<p/>作者：wu
 *<br/>创建时间：2019/11/16 17:06
 */
@RestController
@ResponseResult
@RequestMapping("/sso")
class UmsMemberController {
    @Autowired
    lateinit var memberService: UmsMemberService

    @GetMapping("/getAuthCode")
    fun getAuthCode(@RequestParam phone: String): String {
        return memberService.generateAuthCode(phone)
    }

    @GetMapping("/verifyAuthCode")
    fun verifyAuthCode(@RequestParam phone: String, @RequestParam authCode: String?): String {
        return memberService.verifyAuthCode(phone, authCode)
    }
}