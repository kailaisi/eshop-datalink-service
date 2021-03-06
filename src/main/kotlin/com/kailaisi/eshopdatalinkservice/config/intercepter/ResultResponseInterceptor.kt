package com.kailaisi.eshopdatalinkservice.config.intercepter

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResponseResult
import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 *描述：对返回的结果进行拦截处理
 *<p/>作者：wu
 *<br/>创建时间：2019/11/5 10:46
 */
@Component
class ResultResponseInterceptor :HandlerInterceptor{
    companion object{
        val RESPONSE_RESULT = "RESPONSE-RESULT"
    }
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if(handler is HandlerMethod){
            val clazz = handler.beanType
            val method = handler.method
            if (clazz.isAnnotationPresent(ResponseResult::class.java)) {
                request.setAttribute(RESPONSE_RESULT,clazz.getAnnotation(ResponseResult::class.java))
            }else if(method.isAnnotationPresent(ResponseResult::class.java)){
                request.setAttribute(RESPONSE_RESULT,clazz.getAnnotation(ResponseResult::class.java))
            }
        }
        return super.preHandle(request, response, handler)
    }
}