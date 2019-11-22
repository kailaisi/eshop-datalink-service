package com.kailaisi.eshopdatalinkservice.config.intercepter

import com.kailaisi.eshopdatalinkservice.config.resolver.LoginUserArgumentResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
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
    @Autowired
    lateinit var headerParamsCheckInterceptor: HeaderParamsCheckInterceptor

    /**
     * 拦截器
     */
    override fun addInterceptors(registry: InterceptorRegistry) {
        val apiUri = "/**"
        registry.addInterceptor(headerParamsCheckInterceptor).addPathPatterns(apiUri)
        //登录校验拦截处理
        registry.addInterceptor(loginedAuthInterceptor).addPathPatterns(apiUri)
        //相应结果拦截处理
        registry.addInterceptor(resultResponseInterceptor).addPathPatterns(apiUri)
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        super.addResourceHandlers(registry)
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 参数自动注入
     */
    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        super.addArgumentResolvers(resolvers)
        resolvers.add(loginUserArgumentResolver)
    }
}