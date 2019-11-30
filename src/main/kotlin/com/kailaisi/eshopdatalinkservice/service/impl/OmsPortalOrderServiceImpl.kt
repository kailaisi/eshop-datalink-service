package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.model.qo.OrderParam
import com.kailaisi.eshopdatalinkservice.model.vo.ConfirmOrderResult
import com.kailaisi.eshopdatalinkservice.rabbit.CancelOrderSender
import com.kailaisi.eshopdatalinkservice.service.OmsPortalOrderService
import com.kailaisi.eshopdatalinkservice.service.UmsMemberService
import com.kailaisi.eshopdatalinkservice.util.LoginTokenHelper
import com.kailaisi.eshopdatalinkservice.util.logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *描述：订单管理
 *<p/>作者：wu
 *<br/>创建时间：2019/11/29 16:44
 */
@Service
class OmsPortalOrderServiceImpl : OmsPortalOrderService {
    private val log = logger(this)
    @Autowired
    private lateinit var cancelOrderSender: CancelOrderSender
    @Autowired
    private lateinit var memberService: UmsMemberService

    override fun generateOrder(orderParam: OrderParam) {
        sendDelayMessageCancel(11L)
    }

    private fun sendDelayMessageCancel(id: Long) {
        val delayTime = 30 * 1000L
        cancelOrderSender.sendMessage(id, delayTime)

    }

    override fun cancel(id: Long) {
        log.info("process cancelOrder orderId:$id")
    }

    override fun generateConfirmOrder(): ConfirmOrderResult {
        var result = ConfirmOrderResult()
        var loginUser = LoginTokenHelper.loginUserFromRequest
        //todo 需要根据具体的业务进行处理
        return result
    }
}