package com.kailaisi.eshopdatalinkservice.model

import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.Range
import javax.validation.constraints.*

/**
 *描述： 登录TOKEN辅助类
 *<p/>作者：wu
 *<br/>创建时间：2019/11/6 11:35
 */
class LoginUser {
    val id: Long = 0

    @NotEmpty
    @Length(min = 6, max = 30)
    lateinit var nickName: String

    @Null
    @Pattern(regexp = "^1[3-9]]\\d{9}$")
    var img: String? = null

    @NotNull
    @Range(min = 0, max = 1)
    var gender: Int = 0
}
