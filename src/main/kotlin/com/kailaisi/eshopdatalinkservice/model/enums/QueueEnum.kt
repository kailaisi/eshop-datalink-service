package com.kailaisi.eshopdatalinkservice.model.enums

/**
 *描述：消息队列的类型
 *<p/>作者：wu
 *<br/>创建时间：2019/11/29 13:54
 */
enum class QueueEnum(val exchangeName: String, val queueName: String, val routeKey: String) {
    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("com.kailaisi.direct", "com.kailaisi.cancel", "com.kailaisi.cancel"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("com.kailaisi.direct.ttl", "com.kailaisi.cancel.ttl", "com.kailaisi.cancel.ttl");
}