package com.kailaisi.eshopdatalinkservice.config.intercepter.result

/**
 *描述：平台返回的统一的数据封装
 *<p/>作者：wu
 *<br/>创建时间：2019/11/20 9:03
 */
data class PlatformResult(var data: Any? = null) : Result {
    var result: Int = 1
    var code: Int? = null
    var msg: String? = null
    private fun setResultCode(resultCode: ResultCode): PlatformResult {
        msg = resultCode.msg
        code = resultCode.code
        return this
    }

    companion object {
        fun success() = PlatformResult().setResultCode(ResultCode.SUCCESS).let { it.result = 1 }
        fun success(data: Any?): PlatformResult {
            var result = PlatformResult().setResultCode(ResultCode.SUCCESS)
            result.data = data
            result.result = 1
            return result
        }

        fun failure(resultCode: ResultCode): PlatformResult {
            val result = PlatformResult().setResultCode(resultCode)
            result.result = 0
            return result
        }


        fun failure(resultCode: ResultCode, data: Any?): PlatformResult {
            val result = PlatformResult().setResultCode(resultCode)
            result.data = data
            result.result = 0
            return result
        }

        fun failure(message: String): PlatformResult {
            return PlatformResult().apply {
                code = ResultCode.PARAM_IS_INVALID.code
                msg = message
                result = 0
            }
        }
    }
}