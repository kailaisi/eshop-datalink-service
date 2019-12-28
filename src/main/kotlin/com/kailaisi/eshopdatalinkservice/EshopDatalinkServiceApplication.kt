package com.kailaisi.eshopdatalinkservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig
import tk.mybatis.spring.annotation.MapperScan

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan(basePackages = ["com.kailaisi.eshopdatalinkservice.mgb.mapper", "com.kailaisi.eshopdatalinkservice.search"])
class EshopDatalinkServiceApplication {
    @Bean
    fun jedis(): JedisPool {
        val config = JedisPoolConfig()
        config.maxTotal = 3000
        config.maxIdle = 5
        config.maxWaitMillis = 1000 * 100
        config.testOnBorrow = true
        return JedisPool(config, "127.0.0.1", 6379)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}


fun main(args: Array<String>) {
    //        System.out.println("===========================================");
    /**
     * Springboot整合Elasticsearch 在项目启动前设置一下的属性，防止报错
     * 解决netty冲突后初始化client时还会抛出异常
     * java.lang.IllegalStateException: availableProcessors is already set to [4], rejecting [4]
     */
    System.setProperty("es.set.netty.runtime.available.processors", "false");
    runApplication<EshopDatalinkServiceApplication>(*args)
}
