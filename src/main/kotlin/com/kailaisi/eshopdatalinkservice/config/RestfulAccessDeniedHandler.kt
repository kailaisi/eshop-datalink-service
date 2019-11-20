package com.kailaisi.eshopdatalinkservice.config

import cn.hutool.json.JSONUtil
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.PlatformResult
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResultCode
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
    override fun handle(requset: HttpServletRequest, response: HttpServletResponse, e: AccessDeniedException) {
        val platformResult = PlatformResult.failure(ResultCode.PERMISSION_NO_ACCESS)
        response.status = 200
        response.characterEncoding = "UTF-8"
        response.contentType = "application/json; charset=utf-8"
        response.writer
        response.writer.write(JSONUtil.toJsonStr(platformResult))
    }
}
