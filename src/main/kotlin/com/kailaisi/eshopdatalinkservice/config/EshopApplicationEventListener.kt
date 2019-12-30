package com.kailaisi.eshopdatalinkservice.config

import com.kailaisi.eshopdatalinkservice.service.UmsAdminService
import com.kailaisi.eshopdatalinkservice.util.logger
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import javax.annotation.Resource

/**
 *描述：初始化完成监听器
 *<p/>作者：wu
 *<br/>创建时间：2019/12/26 15:06
 */
@Component
class EshopApplicationEventListener : ApplicationListener<ApplicationReadyEvent> {
    val log = logger(this)
    @Resource
    lateinit var umsAdminService: UmsAdminService
    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        //todo 做初始化操作
        var context = event.applicationContext
        var bean = context.getBean(UmsAdminService::class.java)
        log.info("应用初始化完成${bean},${umsAdminService.toString()}")
    }
}