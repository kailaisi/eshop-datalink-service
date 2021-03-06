package com.kailaisi.eshopdatalinkservice.util

import org.springframework.web.context.ContextLoader
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

import javax.servlet.ServletContext
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

object RequestContextHolderUtil {

    val request: HttpServletRequest
        get() = requestAttributes.request

    val response: HttpServletResponse?
        get() = requestAttributes.response

    val session: HttpSession
        get() = request.session

    val requestAttributes: ServletRequestAttributes
        get() = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes

    val servletContext: ServletContext?
        get() = ContextLoader.getCurrentWebApplicationContext()!!.servletContext

}