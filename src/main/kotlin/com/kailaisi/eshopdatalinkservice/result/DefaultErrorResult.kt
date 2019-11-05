package com.kailaisi.eshopdatalinkservice.result

import com.kailaisi.eshopdatalinkservice.data.Result
import com.kailaisi.eshopdatalinkservice.data.ResultCode
import com.kailaisi.eshopdatalinkservice.util.RequestContextHolderUtil
import org.springframework.http.HttpStatus
import java.util.*

class DefaultErrorResult : Result {

    /**
     * HTTP响应状态码 [org.springframework.http.HttpStatus]
     */
     var status: Int? = null

    /**
     * HTTP响应状态码的英文提示
     */
     var error: String? = null

    /**
     * 异常堆栈的精简信息
     *
     */
     var message: String? = null

    /**
     * 我们系统内部自定义的返回值编码，[ResultCode] 它是对错误更加详细的编码
     *
     * 备注：spring boot默认返回异常时，该字段为null
     */
     var code: Int? = null

    /**
     * 调用接口路径
     */
     var path: String? = null

    /**
     * 异常的名字
     */
     var exception: String? = null

    /**
     * 异常的错误传递的数据
     */
     var errors: Any? = null

    /**
     * 时间戳
     */
     var timestamp: Date? = null

    companion object {

        private var serialVersionUID = 1899083570489722793L

        fun failure(resultCode: ResultCode, e: Throwable, httpStatus: HttpStatus, errors: Any): DefaultErrorResult {
            var result = failure(resultCode, e, httpStatus)
            result.error = errors.toString()
            return result
        }

        fun failure(resultCode: ResultCode, e: Throwable, httpStatus: HttpStatus): DefaultErrorResult {
            var result = DefaultErrorResult().apply {
                code = resultCode.code
                message = resultCode.msg
                status = httpStatus.value()
                error = httpStatus.reasonPhrase
                exception = e.javaClass.name
                path = RequestContextHolderUtil.request.requestURI
                timestamp = Date()
            }
            return result
        }
    }

}