package com.kailaisi.eshopdatalinkservice.control

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResponseResult
import com.kailaisi.eshopdatalinkservice.model.qo.MemberReadHistory
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 *描述：会员商品浏览记录
 *<p/>作者：wu
 *<br/>创建时间：2019/11/27 16:51
 */
@Api(tags = ["MemberReadHistoryController"],value = "会员商品浏览记录")
@RestController
@ResponseResult
class MemberReadHistoryController {
    fun create(@RequestBody memberReadHistory: MemberReadHistory){

    }
}