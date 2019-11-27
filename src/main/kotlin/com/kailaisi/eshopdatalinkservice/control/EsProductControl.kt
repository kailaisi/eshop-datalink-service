package com.kailaisi.eshopdatalinkservice.control

import com.kailaisi.eshopdatalinkservice.config.intercepter.LoginAuth
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResponseResult
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.search.domain.EsProduct
import com.kailaisi.eshopdatalinkservice.service.EsProductService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*

/**
 *描述：搜索商品管理
 *<p/>作者：wu
 *<br/>创建时间：2019/11/27 8:36
 */
@Api(tags = ["EsProductControl"], description = "搜索商品管理")
@RestController
@LoginAuth
@ResponseResult
@RequestMapping("/esProduct")
class EsProductControl {
    @Autowired
    lateinit var esProductService: EsProductService

    @ApiOperation(value = "导入数据库的所有商品数据到ES")
    @PostMapping("/importAll")
    fun importAllList(): Int {
        return esProductService.importAll()
    }

    @ApiOperation(value = "根据商品ID删除信息")
    @PostMapping("/delete")
    fun delete(@RequestBody id: Long): Any? {
        esProductService.delete(id)
        return null
    }

    @ApiOperation(value = "根据商品ID批量删除信息")
    @PostMapping("/delete/batch")
    fun batchDelete(@RequestBody ids: List<Long>): Any? {
        esProductService.delete(ids)
        return null
    }

    @ApiOperation("根据id创建商品")
    @PostMapping("/create")
    fun create(@RequestBody id: Long): EsProduct {
        val product = esProductService.create(id)
        if (product == null) {
            throw BusinessException("创建商品信息失败")
        } else {
            return product
        }
    }

    @ApiOperation("简单的菜品搜索")
    @PostMapping("/search")
    fun search(@RequestParam(required = false) keyword: String,
               @RequestParam(required = false, defaultValue = "0") pageNum: Int,
               @RequestParam(required = false, defaultValue = "5") pageSize: Int): Page<EsProduct>? {
        return esProductService.search(keyword, pageNum, pageSize)
    }

}