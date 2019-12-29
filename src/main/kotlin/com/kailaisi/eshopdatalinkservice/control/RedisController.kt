package com.kailaisi.eshopdatalinkservice.control

import com.kailaisi.eshopdatalinkservice.config.intercepter.LoginAuth
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResponseResult
import com.kailaisi.eshopdatalinkservice.service.RedisActionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 *描述：redis的实战示例
 *<p/>作者：wu
 *<br/>创建时间：2019/12/28 21:18
 */
@ResponseResult
@RestController
@RequestMapping("/redis")
class RedisController {
    @Autowired
    lateinit var redisActionService: RedisActionService

    @PostMapping("/create")
    @LoginAuth
    fun create(@RequestBody hashMap: Map<String, Any?>): String {
        val size = hashMap.get("size") as Int
        val total = hashMap.get("total").toString().toLong()
        return redisActionService.create(size, total)
    }

    @GetMapping("/rob")
    @LoginAuth
    fun rob(@RequestParam id:String):String{
      return  redisActionService.rob(id)
    }
}