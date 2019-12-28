package com.kailaisi.eshopdatalinkservice.control

import com.kailaisi.eshopdatalinkservice.ProductPrice
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResponseResult
import com.kailaisi.eshopdatalinkservice.service.RedisService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *描述：测试返回的数据信息，是否进行了封装
 *<p/>作者：wu
 *<br/>创建时间：2019/11/5 15:04
 */
@RestController
@ResponseResult
@RequestMapping
class TestController {
    @Autowired
    lateinit var redisService: RedisService

    fun testString(msg: String): String {
        return msg
    }

    @RequestMapping()
    fun testBean(): ProductPrice {
        return ProductPrice()
    }

    @RequestMapping("/testException")
    fun testException(): String {
        println(1 / 0)
        return "测试数据"
    }

    @RequestMapping("/testBusinessException")
    fun testBusinessException(): String {
        val map = hashMapOf<String, Any>()
        map["curr_permits"] = 20
        map["max_burst"] = 40
        map["app"] = 1
        redisService.hmset("testInfo", map)
        return "test"
    }
}