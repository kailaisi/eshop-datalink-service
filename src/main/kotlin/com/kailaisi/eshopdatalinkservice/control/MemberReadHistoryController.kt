package com.kailaisi.eshopdatalinkservice.control

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResponseResult
import com.kailaisi.eshopdatalinkservice.model.qo.MemberReadHistory
import com.kailaisi.eshopdatalinkservice.service.MemberReadHistoryService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 *描述：会员商品浏览记录
 *<p/>作者：wu
 *<br/>创建时间：2019/11/27 16:51
 */
@Api(tags = ["MemberReadHistoryController"], value = "会员商品浏览记录")
@RestController
@RequestMapping("/member/history")
@ResponseResult
class MemberReadHistoryController {
    @Autowired
    lateinit var memberReadHistoryService: MemberReadHistoryService

    @ApiOperation("创建浏览记录")
    @PostMapping("/create")
    fun create(@RequestBody memberReadHistory: MemberReadHistory): String? {
        memberReadHistoryService.create(memberReadHistory)
        return null
    }

    @ApiOperation("删除浏览记录")
    @PostMapping("/delete")
    fun delete(@RequestBody ids: List<String>): String? {
        val delete = memberReadHistoryService.delete(ids)
        return null
    }

    @ApiOperation("获取用户的所有的浏览记录")
    @PostMapping("/list/{memberId}")
    fun list(@PathVariable("memberId") memberId: Long): List<MemberReadHistory> {
        return memberReadHistoryService.list(memberId)
    }
}