package com.kailaisi.eshopdatalinkservice.config

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResultCode
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.exception.BusinessException
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 *描述：当接口没有访问权限时，进行处理
 *<p/>作者：wu
 *<br/>创建时间：2019/11/18 15:25
 */
@Component
class RestfulAccessDeniedHandler : AccessDeniedHandler {
    override fun handle(p0: HttpServletRequest?, p1: HttpServletResponse?, p2: AccessDeniedException?) {
        throw throw BusinessException(ResultCode.USER_NOT_LOGGED_IN)
    }
}
