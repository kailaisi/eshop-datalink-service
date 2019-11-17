package com.kailaisi.eshopdatalinkservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import javax.swing.plaf.basic.BasicToolBarUI

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/11/17 19:34
 */
@Configuration
class SwaggerConfig {
    @Bean
    fun createRestApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kalaisi.eshopdatalinkservice.control"))
                .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("SwaggerUI文档")
                .description("mall-tiny")
                .contact("macro")
                .version("1.0.0")
                .build()
    }
}