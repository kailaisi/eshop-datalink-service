package com.kailaisi.eshopdatalinkservice.intercepter

import lombok.extern.slf4j.Slf4j
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/11/6 16:34
 */
@Slf4j
@Component
@Aspect
class RestControllerAspect {
    val logger= LoggerFactory.getLogger(RestControllerAspect::class.java)

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController) || @")
    fun cut(){}
    @Around("@annotion")
    fun apiLog(){

    }
}