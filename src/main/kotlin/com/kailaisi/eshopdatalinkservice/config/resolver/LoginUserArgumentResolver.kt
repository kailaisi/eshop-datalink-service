package com.kailaisi.eshopdatalinkservice.config.resolver

import com.kailaisi.eshopdatalinkservice.model.LoginAuth
import com.kailaisi.eshopdatalinkservice.model.LoginUser
import com.kailaisi.eshopdatalinkservice.util.LoginTokenHelper
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

/**
 *描述：登录用户参数自动解析注入
 *  只需要在Controller方法上使用LoginUser loginUser这个对象类作为参数，便可以自动获取到登录人信息，不需要接口调用方进行参数的传递
 *  当前方法或类上需增加@LoginAuth注解，该注解是代表该方法访问时用户必须是在登录状态下
 *<p/>作者：wu
 *<br/>创建时间：2019/11/7 8:58
 */
@Component
class LoginUserArgumentResolver : HandlerMethodArgumentResolver {
    //根据方法参数判断是否需要对其做转换
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        var method = parameter.method!!
        var clazz = parameter.declaringClass
        var loginAuth = method.isAnnotationPresent(LoginAuth::class.java) || clazz.isAnnotationPresent(LoginAuth::class.java)
        var from = parameter.parameterType.isAssignableFrom(LoginUser::class.java)
        return loginAuth && from
    }

    //需要做转换的类要如何处理
    override fun resolveArgument(p0: MethodParameter, p1: ModelAndViewContainer?, p2: NativeWebRequest, p3: WebDataBinderFactory?): Any? {
        var request = LoginTokenHelper.loginUserFromRequest
        return request
    }
}