package com.kailaisi.eshopdatalinkservice.config.handler

import com.kailaisi.eshopdatalinkservice.config.intercepter.ResultResponseInterceptor
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.DefaultErrorResult
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.PlatformResult
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResponseResult
import com.kailaisi.eshopdatalinkservice.util.FastJsonUtil
import com.kailaisi.eshopdatalinkservice.util.RequestContextHolderUtil
import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice

/**
 *描述：返回的结果增强器，根据属性中，是否含有某个属性来进行判断，是否对返回的结果进行统一的封装
 *<p/>作者：wu
 *<br/>创建时间：2019/11/5 13:29
 */
@ControllerAdvice
class ResponseResultHandler : ResponseBodyAdvice<Any?> {
    override fun supports(p0: MethodParameter, p1: Class<out HttpMessageConverter<*>>): Boolean {
        val request = RequestContextHolderUtil.request
        val attribute = request.getAttribute(ResultResponseInterceptor.RESPONSE_RESULT) as ResponseResult?
        return attribute != null
    }

    override fun beforeBodyWrite(body: Any?, p1: MethodParameter, p2: MediaType, p3: Class<out HttpMessageConverter<*>>, p4: ServerHttpRequest, p5: ServerHttpResponse): Any? {
        val returnClass = p1.method!!.returnType
        val isString = returnClass == String::class.java
        val responseResult = RequestContextHolderUtil.request.getAttribute(ResultResponseInterceptor.RESPONSE_RESULT) as ResponseResult
        val kClass = responseResult.value
        if (kClass.java.isAssignableFrom(PlatformResult::class.java)) {
            return when (body) {
                is DefaultErrorResult -> PlatformResult().apply {
                    result = 0
                    code = body.code
                    msg = body.message
                    data = body.errors
                }
                //controller层中返回的类型是String，但是在ResponseBodyAdvice实现类中，我们把响应的类型修改成了ResponseResult。
                // 这就导致了，上面的这段代码在选择处理MessageConverter的时候，依旧根据之前的String类型选择对应String类型的StringMessageConverter。
                // 而在StringMessageConverter类型，他只接受String类型的返回类型，我们在ResponseBodyAdvice中将返回值从String类型改成ResponseResult类型之后，
                // 调用StringMessageConverter方法发生类型强转。ReponseResult无法转换成String，发生类型转换异常。
                // 因为handler处理类的返回类型是String，为了保证一致性，这里需要将ResponseResult转回去
                //如果返回null，kotlin没办法判断是string还是其他类。所以需要通过注解返回的
                is String? -> if (isString) {
                    FastJsonUtil.bean2Json(PlatformResult.success(body))
                } else {
                    PlatformResult.success(body)
                }
                else -> PlatformResult.success(body)
            }
        }
        return body
    }
}