package com.kailaisi.eshopdatalinkservice.result

import com.kailaisi.eshopdatalinkservice.config.resolver.LoginUserArgumentResolver
import com.kailaisi.eshopdatalinkservice.config.intercepter.LoginedAuthInterceptor
import com.kailaisi.eshopdatalinkservice.config.intercepter.ResultResponseInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 *描述：配置拦截器
 *<p/>作者：wu
 *<br/>创建时间：2019/11/5 13:24
 */
@Configuration
class InterceptorConfig : WebMvcConfigurer {
    @Autowired
    lateinit var resultResponseInterceptor: ResultResponseInterceptor
    @Autowired
    lateinit var loginedAuthInterceptor: LoginedAuthInterceptor
    @Autowired
    lateinit var loginUserArgumentResolver: LoginUserArgumentResolver

    /**
     * 拦截器
     */
    override fun addInterceptors(registry: InterceptorRegistry) {
        val apiUri = "/**"
        //登录校验拦截处理
        registry.addInterceptor(loginedAuthInterceptor).addPathPatterns(apiUri)
        //相应结果拦截处理
        registry.addInterceptor(resultResponseInterceptor).addPathPatterns(apiUri)
    }

    /**
     * 参数自动注入
     */
    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        super.addArgumentResolvers(resolvers)
        resolvers.add(loginUserArgumentResolver)
    }
}