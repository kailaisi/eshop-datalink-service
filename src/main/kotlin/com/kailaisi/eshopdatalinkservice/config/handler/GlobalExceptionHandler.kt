package com.kailaisi.eshopdatalinkservice.config.handler

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.DefaultErrorResult
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.lang.IllegalArgumentException
import javax.servlet.http.HttpServletRequest

/**
 *描述：统一的异常处理
 *<p/>作者：wu
 *<br/>创建时间：2019/11/5 21:16
 */
@RestController
@ControllerAdvice
class GlobalExceptionHandler: BaseGlobalExceptionHandler() {
    @ExceptionHandler(BusinessException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    override fun handleBusinessException(e:BusinessException, request:HttpServletRequest): ResponseEntity<DefaultErrorResult> {
        return super.handleBusinessException(e,request)
    }

    @ExceptionHandler(Throwable::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    override fun handleRuntimeException(e:Throwable, request:HttpServletRequest): DefaultErrorResult {
        return super.handleRuntimeException(e,request)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    override fun handleIllegalArgumentException(e:IllegalArgumentException, request:HttpServletRequest): DefaultErrorResult {
        return super.handleIllegalArgumentException(e,request)
    }
}