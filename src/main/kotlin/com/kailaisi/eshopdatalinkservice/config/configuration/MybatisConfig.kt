package com.kailaisi.eshopdatalinkservice.config.configuration

import DynamicDataSource
import com.alibaba.druid.pool.DruidDataSource
import com.kailaisi.eshopdatalinkservice.config.intercepter.DynamicDataSourceInterceptor
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource


/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/12/21 23:28
 */
@Configuration
class MybatisConfig {

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
                            @Qualifier("slaveDataSource") slaveDataSource: DataSource): DynamicDataSource {
        var map = hashMapOf<Any, Any>()
        map["master"] = masterDataSource
        map["slave"] = slaveDataSource
        val myRoutingDataSource = DynamicDataSource()
        //将两个master和slave两个数据源信息写入到DynamicDataSource的targetDataSources这个属性中
        myRoutingDataSource.setDefaultTargetDataSource(masterDataSource)
        myRoutingDataSource.setTargetDataSources(map)
        return myRoutingDataSource
    }

    @Bean
    @Throws(Exception::class)
    fun sqlSessionFactory(dataSource: DynamicDataSource): SqlSessionFactory? {
        val sqlSessionFactoryBean = SqlSessionFactoryBean()
        sqlSessionFactoryBean.setDataSource(dataSource)
        //为MyBatis增加Plugin拦截器功能
        sqlSessionFactoryBean.setPlugins(arrayOf(DynamicDataSourceInterceptor()))
        sqlSessionFactoryBean.setMapperLocations(PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"))
        return sqlSessionFactoryBean.getObject()
    }

    @Bean
    fun platformTransactionManager(dataSource: DynamicDataSource): PlatformTransactionManager? {
        return DataSourceTransactionManager(dataSource)
    }
}