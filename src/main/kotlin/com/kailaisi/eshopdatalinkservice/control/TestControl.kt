package com.kailaisi.eshopdatalinkservice.control

import com.kailaisi.eshopdatalinkservice.ProductPrice
import com.kailaisi.eshopdatalinkservice.data.ResponseResult
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *描述：测试返回的数据信息，是否进行了封装
 *<p/>作者：wu
 *<br/>创建时间：2019/11/5 15:04
 */
@RestController
@ResponseResult
@RequestMapping("/text")
class TestControl {
    @RequestMapping("/testString")
    fun testString(msg: String): String {
        return msg
    }

    @RequestMapping("/testBean")
    fun testBean(): ProductPrice {
        return ProductPrice()
    }

}