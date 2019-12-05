package com.kailaisi.eshopdatalinkservice.control

import com.kailaisi.eshopdatalinkservice.model.vo.ProductVO
import com.kailaisi.eshopdatalinkservice.service.PmsProductService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *描述：商品管理
 *<p/>作者：wu
 *<br/>创建时间：2019/12/5 16:32
 */
@RestController
@Api(tags = ["PmsProductController"], description = "商品管理")
@RequestMapping("product")
class PmsProductController {

    lateinit var productService: PmsProductService
    @PostMapping("/create")
    @ApiOperation("创建商品")
    fun create(@RequestBody productVo: ProductVO) {
        productVo.setId(null)
        productService.insert(productVo)
    }
}