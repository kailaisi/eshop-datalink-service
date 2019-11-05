package com.kailaisi.eshopdatalinkservice.result

import com.kailaisi.eshopdatalinkservice.intercepter.ResultResponseInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
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

    override fun addInterceptors(registry: InterceptorRegistry) {
        val apiUri = "/**"
        registry.addInterceptor(resultResponseInterceptor).addPathPatterns(apiUri)
    }
}