package com.kailaisi.eshopdatalinkservice.config.configuration

import com.alibaba.druid.pool.DruidDataSource
import com.alibaba.druid.support.http.StatViewServlet
import com.alibaba.druid.support.http.WebStatFilter
import com.kailaisi.eshopdatalinkservice.config.configuration.datasource.DynamicDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import javax.sql.DataSource


/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/12/3 10:48
 */
@Configuration
class DruidConfig {
    lateinit var env: Environment
    /**
     * 配置一个web监控的filter：filterRegistrationBean
     */
    @Bean
    fun webStateFilter(): FilterRegistrationBean<WebStatFilter> {
        val filterRegistrationBean = FilterRegistrationBean(WebStatFilter())
        var param = mapOf("exclusions" to "*.js,*.css,/druid/*")
        filterRegistrationBean.initParameters = param
        filterRegistrationBean.urlPatterns = arrayListOf("/*")
        return filterRegistrationBean
    }

    @Bean
    fun setStatViewServlet(): ServletRegistrationBean<StatViewServlet> {
        val beanServlet = ServletRegistrationBean(StatViewServlet(), "/druid/*")
        val initParams = hashMapOf<String, String>()
        initParams["loginUsername"] = "admin"
        initParams["loginPassword"] = "admin"
        initParams["allow"] = ""
        initParams["resetEnable"] = "true"
        /**默认就是允许所有访问*/
        beanServlet.initParameters = initParams
        return beanServlet
    }

    @Bean(name = ["masterDataSource"])
    @ConfigurationProperties(prefix = "spring.datasource.master")
    fun masterProperties(): DataSource {
        return DruidDataSource()
    }

    @Bean(name = ["slaveDataSource"])
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    fun slaveProperties(): DataSource {
        return DruidDataSource()
    }

    @Bean
    fun myRoutingDataSource(@Qualifier("masterDataSource") masterDataSource: DataSource,
                            @Qualifier("slaveDataSource") slaveDataSource: DataSource): DataSource? {
        val targetDataSources: MutableMap<Any, Any> = HashMap()
        var map = hashMapOf<Any, Any>()
        map["master"] = masterDataSource
        map["slave"] = slaveDataSource
        val myRoutingDataSource = DynamicDataSource()
        myRoutingDataSource.setDefaultTargetDataSource(masterDataSource)
        myRoutingDataSource.setTargetDataSources(targetDataSources)
        return myRoutingDataSource
    }

}