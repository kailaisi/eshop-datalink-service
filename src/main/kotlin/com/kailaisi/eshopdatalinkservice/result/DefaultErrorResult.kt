package com.kailaisi.eshopdatalinkservice.result

import com.kailaisi.eshopdatalinkservice.data.Result
import com.kailaisi.eshopdatalinkservice.data.ResultCode
import com.kailaisi.eshopdatalinkservice.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.exception.BusinessExceptionEnum
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

        fun failure(resultCode: ResultCode, e: Throwable, httpStatus: HttpStatus, errors: Any?): DefaultErrorResult {
            val result = failure(resultCode, e, httpStatus)
            result.errors = errors
            return result
        }

        fun failure(resultCode: ResultCode, e: Throwable, httpStatus: HttpStatus): DefaultErrorResult {
            return  DefaultErrorResult().apply {
                code = resultCode.code
                message = resultCode.msg
                status = httpStatus.value()
                error = httpStatus.reasonPhrase
                exception = e.javaClass.name
                path = RequestContextHolderUtil.request.requestURI
                timestamp = Date()
            }
        }

        fun failure(e: BusinessException): DefaultErrorResult {
            val ee = BusinessExceptionEnum.getByEClass(e.javaClass)
            if (ee != null) {
                return failure(ee.resultCode, e, ee.httpStatus)
            }
            val failure = DefaultErrorResult.failure(e.resultCode ?: ResultCode.SUCCESS, e, HttpStatus.OK, e.data)
            e.message?.let { failure.message = it }
            return failure
        }
    }

}