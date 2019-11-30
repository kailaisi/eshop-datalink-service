package com.kailaisi.eshopdatalinkservice.control

import com.kailaisi.eshopdatalinkservice.config.intercepter.LoginAuth
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.PlatformResult
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResponseResult
import com.kailaisi.eshopdatalinkservice.model.qo.OrderParam
import com.kailaisi.eshopdatalinkservice.model.vo.ConfirmOrderResult
import com.kailaisi.eshopdatalinkservice.service.OmsPortalOrderService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/11/29 16:31
 */
@RestController
@Api(tags = ["OmsPortalOrderController"], description = "订单管理")
@ResponseResult
@RequestMapping("/order")
@LoginAuth
class OmsPortalOrderController {
    @Autowired
    lateinit var portalOrderService: OmsPortalOrderService

    @PostMapping("/generateConfirmOrder")
    fun generateConfirmOrder(): ConfirmOrderResult {
       return portalOrderService.generateConfirmOrder()
    }

    @ApiOperation("根据购物车信息生成订单")
    @PostMapping("/generateOrder")
    fun generateOrder(@RequestBody orderParam: OrderParam): PlatformResult {
        portalOrderService.generateOrder(orderParam)
        return PlatformResult.success("下单成功")
    }
}