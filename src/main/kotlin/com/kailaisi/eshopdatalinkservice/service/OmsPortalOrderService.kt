package com.kailaisi.eshopdatalinkservice.service

import com.kailaisi.eshopdatalinkservice.model.qo.OrderParam
import com.kailaisi.eshopdatalinkservice.model.vo.ConfirmOrderResult
import org.springframework.transaction.annotation.Transactional

/**
 *描述：订单处理系统
 *<p/>作者：wu
 *<br/>创建时间：2019/11/29 16:41
 */
interface OmsPortalOrderService {
    /**
     * 根据提交的信息生成订单
     */
    @Transactional
    fun generateOrder(orderParam: OrderParam)

    /**
     * 取消超时的订单
     */
    @Transactional
    fun cancel(id: Long)

    fun generateConfirmOrder(): ConfirmOrderResult
}
