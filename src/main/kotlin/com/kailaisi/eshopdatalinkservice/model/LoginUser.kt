package com.kailaisi.eshopdatalinkservice.model

import com.kailaisi.eshopdatalinkservice.mgb.Model
import io.swagger.annotations.ApiModelProperty
import java.util.*

/**
 *描述： 登录TOKEN辅助类
 *<p/>作者：wu
 *<br/>创建时间：2019/11/6 11:35
 */
class LoginUser : Model {
    @ApiModelProperty("用户ID")
    private var id: Long? = null
    @ApiModelProperty("登陆账号")
    lateinit var username: String
    @ApiModelProperty("")
    var password: String? = null
    @ApiModelProperty("头像")
    var icon: String? = null
    @ApiModelProperty("邮箱")
    var email: String? = null
    @ApiModelProperty("昵称")
    var nickName: String? = null
    @ApiModelProperty("备注信息")
    var note: String? = null
    @ApiModelProperty("创建时间")
    private var createTime: Date? = null
    @ApiModelProperty("最后登录时间")
    var loginTime: Date? = null
    @ApiModelProperty("更新时间")
    var updateTime: Date? = null
}
