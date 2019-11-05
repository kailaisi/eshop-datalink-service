package com.kailaisi.eshopdatalinkservice.data

import java.io.Serializable
import kotlin.properties.Delegates

/**
 *描述：返回的错误码和对应的提示信息
 *<p/>作者：wu
 *<br/>创建时间：2019/11/5 10:48
 */
enum class ResultCode(val code: Int, val msg: String) {
    SUCCESS(1, "成功"),
    USER_NOT_LOGIN(1002, "用户未登陆，访问的路径需要验证，请登陆")
}

interface Result : Serializable


data class PlatformResult(var data: Any?=null) : Result {
    var code: Int? = null
    var msg: String? = null
    private fun setResultCode(resultCode: ResultCode): PlatformResult {
        msg = resultCode.msg
        code = resultCode.code
        return this
    }

    companion object {
        fun success() = PlatformResult().setResultCode(ResultCode.SUCCESS)
        fun success(data: Any?): PlatformResult {
            var result = PlatformResult().setResultCode(ResultCode.SUCCESS)
            result.data=data
            return result
        }

        fun failure(resultCode: ResultCode) = PlatformResult().setResultCode(resultCode)
        fun failure(resultCode: ResultCode, data: Any?) = PlatformResult().setResultCode(resultCode).let { it.data = data }
        fun failure(message: String) {
            PlatformResult().apply {
                code = ResultCode.USER_NOT_LOGIN.code
                msg = message
            }
        }
    }
}