package com.kailaisi.eshopdatalinkservice.handler

import com.kailaisi.eshopdatalinkservice.data.ResultCode
import com.kailaisi.eshopdatalinkservice.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.result.DefaultErrorResult
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import javax.servlet.http.HttpServletRequest

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/11/5 21:21
 */
open class BaseGlobalExceptionHandler {
    open fun handleRuntimeException(e: RuntimeException, request: HttpServletRequest): DefaultErrorResult {
        return DefaultErrorResult.failure(ResultCode.SYSTEM_INNER_ERROR, e, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    open fun handleBusinessException(e: BusinessException, request: HttpServletRequest): ResponseEntity<DefaultErrorResult> {
        val failure = DefaultErrorResult.failure(e)
        return ResponseEntity.status(HttpStatus.valueOf(failure.status!!))
                .body(failure)
    }
}