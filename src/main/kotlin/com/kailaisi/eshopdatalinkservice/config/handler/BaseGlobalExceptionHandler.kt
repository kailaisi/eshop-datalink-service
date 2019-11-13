package com.kailaisi.eshopdatalinkservice.config.handler

import com.kailaisi.eshopdatalinkservice.data.ResultCode
import com.kailaisi.eshopdatalinkservice.result.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.result.DefaultErrorResult
import com.kailaisi.eshopdatalinkservice.util.ParameterInvalidItemHelper
import com.kailaisi.eshopdatalinkservice.util.logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.BindException
import org.springframework.web.bind.MethodArgumentNotValidException
import java.lang.IllegalArgumentException
import javax.servlet.http.HttpServletRequest
import javax.validation.ConstraintViolationException


/**
 *描述：异常的统一处理，将异常封装为DefaultErrorResult信息返回。在接口同一封装中。就可以根据DefaultErrorResult类来封装错误信息了
 *<p/>作者：wu
 *<br/>创建时间：2019/11/5 21:21
 */
open class BaseGlobalExceptionHandler {
    var log = logger(this)
    /**
     * 违反约束异常
     */
    open fun handleConstraintViolationException(e: ConstraintViolationException, request: HttpServletRequest): DefaultErrorResult {
        log.error("handleConstraintViolationException start, uri:${request.requestURI}, caused by:$e ")
        val parameterInvalidItemList = ParameterInvalidItemHelper.convertCVSetToParameterInvalidItemList(e.constraintViolations)
        return DefaultErrorResult.failure(ResultCode.PARAM_IS_INVALID, e, HttpStatus.BAD_REQUEST, parameterInvalidItemList)
    }

    /**
     * 处理验证参数封装错误时异常
     */
    open fun handleConstraintViolationException(e: HttpMessageNotReadableException, request: HttpServletRequest): DefaultErrorResult {
        log.error("handleConstraintViolationException start, uri:${request.requestURI}, caused by:$e ")
        return DefaultErrorResult.failure(ResultCode.PARAM_IS_INVALID, e, HttpStatus.BAD_REQUEST)
    }

    /**
     * 处理参数绑定时异常（反400错误码）
     */
    open fun handleBindException(e: BindException, request: HttpServletRequest): DefaultErrorResult {
        log.error("handleBindException start, uri:${request.requestURI}, caused by:$e ")
        val parameterInvalidItemList = ParameterInvalidItemHelper.convertBindingResultToMapParameterInvalidItemList(e.getBindingResult())
        return DefaultErrorResult.failure(ResultCode.PARAM_IS_INVALID, e, HttpStatus.BAD_REQUEST, parameterInvalidItemList)
    }

    /**
     * 处理使用@Validated注解时，参数验证错误异常（反400错误码）
     */
    open fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException, request: HttpServletRequest): DefaultErrorResult {
        log.error("handleMethodArgumentNotValidException start, uri:${request.requestURI}, caused by:$e ")
        val parameterInvalidItemList = ParameterInvalidItemHelper.convertBindingResultToMapParameterInvalidItemList(e.bindingResult)
        return DefaultErrorResult.failure(ResultCode.PARAM_IS_INVALID, e, HttpStatus.BAD_REQUEST, parameterInvalidItemList)
    }

    /**
     * 处理使用@Validated注解时，参数验证错误异常（反400错误码）
     */
    open fun handleIllegalArgumentException(e: IllegalArgumentException, request: HttpServletRequest): DefaultErrorResult {
        log.error("handleIllegalArgumentException start, uri:${request.requestURI}, caused by:$e ")
        return DefaultErrorResult.failure(ResultCode.PARAM_IS_INVALID, e, HttpStatus.BAD_REQUEST)
    }

    open fun handleRuntimeException(e: Throwable, request: HttpServletRequest): DefaultErrorResult {
        log.error("handleThrowable start, uri:${request.requestURI}, caused by:$e ")
        return DefaultErrorResult.failure(ResultCode.SYSTEM_INNER_ERROR, e, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    open fun handleBusinessException(e: BusinessException, request: HttpServletRequest): ResponseEntity<DefaultErrorResult> {
        log.error("handleBusinessException start, uri:${request.requestURI}, caused by:$e ")
        val failure = DefaultErrorResult.failure(e)
        return ResponseEntity.status(HttpStatus.OK)
                .body(failure)
    }
}