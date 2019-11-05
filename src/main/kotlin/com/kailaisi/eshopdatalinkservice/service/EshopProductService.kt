package com.kailaisi.eshopdatalinkservice.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/21 10:26
 */
interface EshopProductService {
    @RequestMapping("/brand/findById", method = arrayOf(RequestMethod.POST))
    fun findBrandById(@RequestParam(value = "id") id: Long): String?

    @RequestMapping("/brand/findByIds", method = arrayOf(RequestMethod.POST))
    fun findBrandByIds(@RequestParam(value = "id") id: String): String

    @RequestMapping("/category/findById", method = arrayOf(RequestMethod.POST))
    fun findCategoryById(@RequestParam(value = "id") id: Long): String

    @RequestMapping("/product/findById", method = arrayOf(RequestMethod.POST))
    fun findProductById(@RequestParam(value = "id") id: Long): String

    @RequestMapping("/product_desc/findById", method = arrayOf(RequestMethod.POST))
    fun findProductDescById(@RequestParam(value = "id") id: Long): String

    @RequestMapping("/product_desc/findByProductId", method = arrayOf(RequestMethod.POST))
    fun findProductDescByProductId(@RequestParam(value = "id") id: Long): String

    @RequestMapping("/product-specification/findById", method = arrayOf(RequestMethod.POST))
    fun findProductSpecificationById(@RequestParam(value = "id") id: Long): String

    @RequestMapping("/product-specification/findByProductId", method = arrayOf(RequestMethod.POST))
    fun findProductSpecificationByProductId(@RequestParam(value = "id") id: Long): String


    @RequestMapping("/product-property/findById", method = arrayOf(RequestMethod.POST))
    fun findProductPropertyById(@RequestParam(value = "id") id: Long): String

    @RequestMapping("/product-property/findByProductId", method = arrayOf(RequestMethod.POST))
    fun findProductPropertyByProductId(@RequestParam(value = "id") id: Long): String

}