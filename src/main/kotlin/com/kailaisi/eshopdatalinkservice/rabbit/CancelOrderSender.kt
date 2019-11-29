package com.kailaisi.eshopdatalinkservice.rabbit

import com.kailaisi.eshopdatalinkservice.model.enums.QueueEnum
import com.kailaisi.eshopdatalinkservice.util.logger
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 *描述：发送取消订单的消息
 *<p/>作者：wu
 *<br/>创建时间：2019/11/29 13:51
 */
@Component
class CancelOrderSender {
    val log = logger(this)
    @Autowired
    private lateinit var amqpTemplate: AmqpTemplate

    fun sendMessage(orderId: Long, delay: Long) {
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_TTL_ORDER_CANCEL.exchangeName, QueueEnum.QUEUE_TTL_ORDER_CANCEL.routeKey, orderId
        ) { message ->
            message.messageProperties.expiration = delay.toString()
            message
        }
        log.info("send delay message orderId:$orderId")
    }
}