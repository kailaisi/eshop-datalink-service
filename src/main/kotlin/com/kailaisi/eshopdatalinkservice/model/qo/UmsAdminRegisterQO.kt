package com.kailaisi.eshopdatalinkservice.model.qo

import io.swagger.annotations.ApiModelProperty
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotEmpty

/**
 * 用户登录参数
 * Created by macro on 2018/4/26.
 */
class UmsAdminRegisterQO {
    @ApiModelProperty(value = "用户名", required = true)
    lateinit var username: @NotEmpty(message = "用户名不能为空") String
    @ApiModelProperty(value = "密码", required = true)
    lateinit var password: @NotEmpty(message = "密码不能为空") String
    @ApiModelProperty(value = "用户头像")
    var icon: String? = null
    @ApiModelProperty(value = "邮箱")
    var email: @Email(message = "邮箱格式不合法") String? = null
    @ApiModelProperty(value = "用户昵称")
    var nickName: String? = null
    @ApiModelProperty(value = "备注")
    var note: String? = null
}