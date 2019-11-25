package com.kailaisi.eshopdatalinkservice.task

import com.kailaisi.eshopdatalinkservice.util.logger
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/11/25 16:11
 */
@Component
class OrderTimeOutCancelTask {
    val log = logger(this)

    @Scheduled(cron = "1-2 0/1 * * * ? ")
    fun cancelTimeOutOrder() {
        log.info("取消订单，根据sku编号释放锁定库存")
    }
}