package com.kailaisi.eshopdatalinkservice.config.configuration

import com.kailaisi.eshopdatalinkservice.model.enums.QueueEnum
import org.springframework.amqp.core.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


/**
 *描述：rabbit消息队列的设置
 *<p/>作者：wu
 *<br/>创建时间：2019/11/29 13:58
 */
@Configuration
class RabbitMqConfig {
    /**
     * 定义消息队列的交换机类型和名称
     * 实际消费队列
     */
    @Bean
    fun orderDirect():DirectExchange{
        return ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_ORDER_CANCEL.exchangeName)
                .durable(true)
                .build() as DirectExchange
    }

    /**
     * 订单延迟消息队列
     */
    fun orderTtlDirect(): DirectExchange {
        return ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_TTL_ORDER_CANCEL.exchangeName)
                .durable(true)
                .build() as DirectExchange
    }
    /**
     * 订单实际消费队列
     */
    @Bean
    fun orderQueue(): Queue? {
        return Queue(QueueEnum.QUEUE_ORDER_CANCEL.queueName)
    }

    /**
     * 订单延迟队列（死信队列）
     */
    @Bean
    fun orderTtlQueue(): Queue? {
        return QueueBuilder
                .durable(QueueEnum.QUEUE_TTL_ORDER_CANCEL.queueName)
                .withArgument("x-dead-letter-exchange", QueueEnum.QUEUE_ORDER_CANCEL.exchangeName) //到期后转发的交换机
                .withArgument("x-dead-letter-routing-key", QueueEnum.QUEUE_ORDER_CANCEL.routeKey) //到期后转发的路由键
                .build()
    }

    /**
     * 订单队列绑定到交换机
     */
    @Bean
    fun orderBinding(orderDirect:DirectExchange,orderQueue: Queue): Binding {
     return   BindingBuilder
                .bind(orderQueue)
                .to(orderDirect)
                .with(QueueEnum.QUEUE_ORDER_CANCEL.routeKey)
    }
    /**
     * 将订单延迟队列绑定到交换机
     */
    @Bean
    fun orderTtlBinding(orderTtlDirect: DirectExchange?, orderTtlQueue: Queue?): Binding? {
        return BindingBuilder
                .bind(orderTtlQueue)
                .to(orderTtlDirect)
                .with(QueueEnum.QUEUE_TTL_ORDER_CANCEL.routeKey)
    }
}