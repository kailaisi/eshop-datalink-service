package com.kailaisi.eshopdatalinkservice.config

import cn.hutool.core.util.ClassUtil
import com.kailaisi.eshopdatalinkservice.util.dropLastString
import com.kailaisi.eshopdatalinkservice.util.logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations
import org.springframework.core.annotation.AnnotatedElementUtils
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.condition.*
import org.springframework.web.servlet.mvc.method.RequestMappingInfo
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
import java.lang.reflect.Method


/**
 *描述：通过继承WebMvcRegistrations，里面覆写getRequestMappingHandlerMapping()方法，可以注入自己的RequestMappingHandler
 * 来实现对于@RequestMapping缺少value的自动url注入，
 *<p/>作者：wu
 *<br/>创建时间：2019/12/27 23:14
 */
@Component
class RequestMappingHandlerConfig : WebMvcRegistrations {
    override fun getRequestMappingHandlerMapping(): RequestMappingHandlerMapping {
        return ControllerRequestMapping()
    }
}
/**
 *描述：RequestMappingHandlerMapping
 *<p/>作者：wu
 *<br/>创建时间：2019/12/28 11:44
 */
class ControllerRequestMapping : RequestMappingHandlerMapping() {
    val log = logger(this)

    init {
        log.info("ControllerRequestMapping 被加载")
    }

    //父类的属性
    private val useSuffixPatternMatch = true
    private val useTrailingSlashMatch = true

    var basePackage: String? = null
        @Value("\${basePackage}")
        set(value) {
            field = value
        }

    override fun getMappingForMethod(method: Method, handlerType: Class<*>): RequestMappingInfo? {
        var info: RequestMappingInfo? = null
        var annotation = AnnotatedElementUtils.findMergedAnnotation(method, RequestMapping::class.java)
        annotation?.let {
            var methodCondition = getCustomMethodCondition(method)
            info = createRequestMappingInfo(annotation, methodCondition, method, handlerType)
            var typeAnnotation = AnnotatedElementUtils.findMergedAnnotation(handlerType, RequestMapping::class.java)
            typeAnnotation?.let {
                var typeCondition = getCustomTypeCondition(handlerType)
                info = createRequestMappingInfo(typeAnnotation, typeCondition, method, handlerType).combine(info!!)
            }
        }
        return info
    }

    private fun createRequestMappingInfo(annotation: RequestMapping, customCondition: RequestCondition<*>?, method: Method, handlerType: Class<*>): RequestMappingInfo {
        var patterns = resolveEmbeddedValuesInPatterns(annotation.value)
        if (patterns.isEmpty()) {
            //证明RequestMapping里面没有写value属性，此时要进行自己url的拼装。
            val builder = StringBuilder()
            basePackage?.let {
                //例如我的类位置是  com.kailaisi.eshopdatalinkservice.controller.EsProductController，那么我们这里会去掉
                //basePackage  com.kailaisi.eshopdatalinkservice   然后再去掉最后的controller，只剩下了文件名
                //然后文件名去掉Controller后缀，我们的url地址就是/esproduct
                val packagePath = ClassUtil.getPackagePath(handlerType)
                var substring = packagePath.substring(it.length)//去掉包名
                if (substring.endsWith("/controller")) {
                    //去掉controller这个包文件
                    substring = substring.dropLast("/controller".length)
                }
                builder.append(substring.toLowerCase()).append("/")
            }
            //去掉后缀名小写字母,例如我的类名是UserLoginController   那么最后名字是userlogin
            var clazzName = handlerType.simpleName.dropLastString("Controller")
            builder.append(clazzName.toLowerCase()).append("/").append(method.name.toLowerCase())
            patterns = arrayOf(builder.toString())
        }
        return RequestMappingInfo(
                PatternsRequestCondition(patterns, urlPathHelper, pathMatcher,
                        this.useSuffixPatternMatch, this.useTrailingSlashMatch, fileExtensions),
                RequestMethodsRequestCondition(*annotation.method),
                ParamsRequestCondition(*annotation.params),
                HeadersRequestCondition(*annotation.headers),
                ConsumesRequestCondition(annotation.consumes, annotation.headers),
                ProducesRequestCondition(annotation.produces, annotation.headers, contentNegotiationManager),
                customCondition)
    }

}