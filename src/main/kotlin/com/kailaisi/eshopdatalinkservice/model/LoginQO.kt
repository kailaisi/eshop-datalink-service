package com.kailaisi.eshopdatalinkservice.model

import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.NotEmpty

/**
 *描述：登录的员工信息
 *<p/>作者：wu
 *<br/>创建时间：2019/11/7 11:55
 */
class LoginQO {
    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    lateinit var username: String

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    lateinit var pwd: String

    @ApiModelProperty(value = "凭证类型")
    lateinit var type: List<String>
}
