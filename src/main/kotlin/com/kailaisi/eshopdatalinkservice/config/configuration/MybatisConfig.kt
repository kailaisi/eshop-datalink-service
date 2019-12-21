package com.kailaisi.eshopdatalinkservice.config.configuration

import com.kailaisi.eshopdatalinkservice.config.intercepter.DynamicDataSourceInterceptor
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.springframework.beans.factory.annotation.Autowired
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
    @Autowired
    lateinit var myRoutingDataSource: DataSource

    @Bean
    @Throws(Exception::class)
    fun sqlSessionFactory(): SqlSessionFactory? {
        val sqlSessionFactoryBean = SqlSessionFactoryBean()
        sqlSessionFactoryBean.setDataSource(myRoutingDataSource)
        sqlSessionFactoryBean.setPlugins(arrayOf(DynamicDataSourceInterceptor()))
        sqlSessionFactoryBean.setMapperLocations(PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"))
        return sqlSessionFactoryBean.getObject()
    }

    @Bean
    fun platformTransactionManager(): PlatformTransactionManager? {
        return DataSourceTransactionManager(myRoutingDataSource)
    }
}