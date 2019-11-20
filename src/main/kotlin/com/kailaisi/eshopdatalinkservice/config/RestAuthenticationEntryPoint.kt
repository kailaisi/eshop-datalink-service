package com.kailaisi.eshopdatalinkservice.config

import cn.hutool.json.JSONUtil
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.PlatformResult
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResultCode
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 *描述：未登录或者token失效时，进行的返回结果处理
 *<p/>作者：wu
 *<br/>创建时间：2019/11/18 15:26
 */
@Component
class RestAuthenticationEntryPoint : AuthenticationEntryPoint {
    override fun commence(p0: HttpServletRequest, response: HttpServletResponse, p2: AuthenticationException) {
        val platformResult = PlatformResult.failure(ResultCode.USER_NOT_LOGGED_IN)
        response.status = 200
        response.characterEncoding = "UTF-8"
        response.contentType = "application/json; charset=utf-8"
        response.writer.write(JSONUtil.toJsonStr(platformResult))
    }
}
