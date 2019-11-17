package com.kailaisi.eshopdatalinkservice.config.intercepter.result

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.PlatformResult
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.Result
import kotlin.reflect.KClass

/**
 *描述：定义注解，当类或者方法有这个注解时，进行返回的封装
 *<p/>作者：wu
 *<br/>创建时间：2019/11/5 11:09
 */
@Target(AnnotationTarget.FUNCTION,AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class ResponseResult(val value:KClass<out Result> = PlatformResult::class)


