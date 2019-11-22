package com.kailaisi.eshopdatalinkservice.model

import com.kailaisi.eshopdatalinkservice.mgb.Model
import java.util.*

/**
 *描述：登录的token信息
 *<p/>作者：
 *<br/>创建时间：
 */
class LoginToken:Model {

    lateinit var id: String

    var ttl: Long? = null

    var ip: String? = null

    /**
     * 平台 [CallSourceEnum]
     */
    var platform: String? = null

    lateinit var createTime: Date

    var loginUser: LoginUser? = null

}
