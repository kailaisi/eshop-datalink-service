package com.kailaisi.eshopdatalinkservice.config.intercepter

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResultCode
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.model.CallSourceEnum
import com.kailaisi.eshopdatalinkservice.model.HeaderConstants
import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import tk.mybatis.mapper.util.StringUtil
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 *描述：HEADER头参数校验
 *<p/>作者：wu
 *<br/>创建时间：2019/11/14 14:05
 */
@Component
class HeaderParamsCheckInterceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (handler is HandlerMethod) {
            val callSource = request.getHeader(HeaderConstants.CALL_SOURCE)
            val apiVersion = request.getHeader(HeaderConstants.API_VERSION)
            val appVersion = request.getHeader(HeaderConstants.APP_VERSION)
            if (callSource.isNullOrBlank() || apiVersion.isNullOrBlank()) {
                throw BusinessException(ResultCode.HEADER_NOT_COMPLETE)
            }
            try {
                apiVersion.toDouble()
            } catch (e: NumberFormatException) {
                throw  BusinessException(ResultCode.HEADER_ERROR)
            }
            if ((CallSourceEnum.ANDROID.name == callSource || CallSourceEnum.IOS.name == callSource) && StringUtil.isEmpty(appVersion)) {
                throw  BusinessException(ResultCode.HEADER_ERROR)
            }
            if (!CallSourceEnum.isValid(callSource)) {
                throw  BusinessException(ResultCode.HEADER_ERROR)
            }
        }
        return true
    }
}