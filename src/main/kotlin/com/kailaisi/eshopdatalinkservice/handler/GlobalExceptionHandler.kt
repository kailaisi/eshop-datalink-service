package com.kailaisi.eshopdatalinkservice.handler

import com.kailaisi.eshopdatalinkservice.data.Result
import com.kailaisi.eshopdatalinkservice.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.result.DefaultErrorResult
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException
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
    override fun handleRuntimeException(e:RuntimeException, request:HttpServletRequest): DefaultErrorResult {
        return super.handleRuntimeException(e,request)
    }

}