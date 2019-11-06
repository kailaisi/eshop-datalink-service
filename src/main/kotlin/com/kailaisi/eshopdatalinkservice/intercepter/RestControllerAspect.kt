package com.kailaisi.eshopdatalinkservice.intercepter

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.kailaisi.eshopdatalinkservice.data.HeaderConstants
import com.kailaisi.eshopdatalinkservice.handler.GlobalExceptionHandler
import com.kailaisi.eshopdatalinkservice.util.IPUtils
import com.kailaisi.eshopdatalinkservice.util.LoginTokenHelper
import com.kailaisi.eshopdatalinkservice.util.RequestContextHolderUtil
import com.kailaisi.eshopdatalinkservice.util.logger
import lombok.extern.slf4j.Slf4j
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.multipart.MultipartFile
import java.lang.reflect.Method
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 *描述：日志记录的AOP实现，每个使用RestController注解的方法都会自动的记录方法log信息
 *<p/>作者：wu
 *<br/>创建时间：2019/11/6 16:34
 */
@Slf4j
@Component
@Aspect
class RestControllerAspect {
    val log = logger(this)
    @Around("@within(org.springframework.web.bind.annotation.RestController) || @annotation(org.springframework.web.bind.annotation.RestController)")
    fun apiLog(joinPoint: ProceedingJoinPoint): Any? {
        val signature = joinPoint.signature as MethodSignature
        val method = signature.method
        if (!needToLog(method)) {
            return joinPoint.proceed()
        }
        val methodNamed = signature.name
        val paramsJson = getParamsJson(joinPoint)
        val request = RequestContextHolderUtil.request
        val ip = IPUtils.getRealIP(request)
        val user = LoginTokenHelper.loginUserFromRequest
        val requester = user?.id ?: "unknown"
        val callSource = request.getHeader(HeaderConstants.CALL_SOURCE)
        val appVersion = request.getHeader(HeaderConstants.APP_VERSION)
        val apiVersion = request.getHeader(HeaderConstants.API_VERSION)
        val userAgent = request.getHeader("user-agent")
        log.info("Started request requester [$requester] method [$methodNamed] params [$paramsJson] IP [$ip] callSource [$callSource] appVersion [$appVersion] apiVersion [$apiVersion] userAgent [$userAgent]")
        val start = System.currentTimeMillis()
        val result = joinPoint.proceed()
        log.info("Ended request requester [$requester] method [$methodNamed] params[$paramsJson] response is [${deleteSensitiveContent(result)}] cost [${System.currentTimeMillis() - start}] millis")
        return result
    }

    /**
     * 判断是否需要进行日志的打印
     */
    private fun needToLog(method: Method): Boolean {
        return method.getAnnotation(GetMapping::class.java) == null
                && method.declaringClass != GlobalExceptionHandler::class.java
    }

    /**
     * 将请求的参数信息封装为一个json字符串
     */
    fun getParamsJson(joinPoint: ProceedingJoinPoint): String {
        return joinPoint.args.joinToString {
            when (it) {
                is HttpServletResponse -> it.javaClass.simpleName
                is HttpServletRequest -> it.javaClass.simpleName
                is MultipartFile -> "${it.javaClass.simpleName} size:${it.size}"
                else -> {
                    deleteSensitiveContent(it)
                }
            }
        }
    }

    /**
     * 删除类中的敏感信息（帐号密码证书等）
     */
    private fun deleteSensitiveContent(it: Any?): String {
        var jsonObject = JSONObject()
        var b = it is Exception
        var b1 = it == null
        log.info("$it   $b     $b1")
        if (b1 || b) {
          return  jsonObject.toJSONString()
        }
        try {
            //隐藏敏感信息
            val param = JSON.toJSONString(it)
            val arrays = mutableListOf("pwd", "password")
            jsonObject = JSON.parseObject(param)
            arrays.forEach { array ->
                if (jsonObject.containsKey(array)) {
                    jsonObject[array] = "***************"
                }
            }
        } catch (e: Exception) {
           return it.toString()
        }
        return jsonObject.toJSONString()
    }
}