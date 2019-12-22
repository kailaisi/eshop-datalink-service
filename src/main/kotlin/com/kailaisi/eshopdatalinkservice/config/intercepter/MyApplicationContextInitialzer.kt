package com.kailaisi.eshopdatalinkservice.config.intercepter

import com.kailaisi.eshopdatalinkservice.service.UmsAdminService
import com.kailaisi.eshopdatalinkservice.util.logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/12/22 14:31
 */
@Component
class MyApplicationContextInitialzer : ApplicationRunner {
    val log = logger(this)
    @Autowired
    lateinit var umsAdminService: UmsAdminService
    @Autowired
    lateinit var booleanFilter: BoomFilter

    override fun run(args: ApplicationArguments?) {
        //启动完成,进行一些初始化工作，例如
        log.info("应用程序启动完成")
        var all = umsAdminService.selectAll()
        all.forEach {
            booleanFilter.add(it.username)
        }
    }
}