package com.kailaisi.eshopdatalinkservice.control

import com.kailaisi.eshopdatalinkservice.config.intercepter.LoginAuth
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResponseResult
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.model.vo.CommonPage
import com.kailaisi.eshopdatalinkservice.search.domain.EsProduct
import com.kailaisi.eshopdatalinkservice.service.EsProductService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
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
    @PostMapping("/delete/{id}")
    fun delete(@PathVariable id:Long): String? {
        esProductService.delete(id)
        return null
    }

    @ApiOperation(value = "根据商品ID批量删除信息")
    @PostMapping("/delete/batch")
    fun batchDelete(@RequestBody ids: List<Long>): String? {
        esProductService.delete(ids)
        return null
    }

    @ApiOperation("根据id创建商品")
    @PostMapping("/create/{id}")
    fun create(@PathVariable id:Long): EsProduct {
        val product = esProductService.create(id)
        if (product == null) {
            throw BusinessException("创建商品信息失败")
        } else {
            return product
        }
    }

    @ApiOperation("简单的菜品搜索")
    @GetMapping("/search/simple")
    fun search(@RequestParam keyword: String,
               @RequestParam(required = false, defaultValue = "0") pageNum: Int,
               @RequestParam(required = false, defaultValue = "5") pageSize: Int): Page<EsProduct>? {
        return esProductService.search(keyword, pageNum, pageSize)
    }
    @ApiOperation(value = "综合搜索、筛选、排序")
    @ApiImplicitParam(name = "sort", value = "排序字段:0->按相关度；1->按新品；2->按销量；3->价格从低到高；4->价格从高到低", defaultValue = "0", allowableValues = "0,1,2,3,4", paramType = "query", dataType = "integer")
    @PostMapping(value = ["/search"])
    @ResponseBody
    fun search(@RequestBody hashMap: Map<String,Any?>): CommonPage<EsProduct>? {
        val keyword= hashMap["keyword"] as String
        val brandId= hashMap["brandId"] as Long?
        val productCategoryId= hashMap["productCategoryId"] as Long?
        var pageNum= hashMap["pageNum"] as Int?
        var pageSize= hashMap["pageSize"] as Int?
        pageNum=pageNum?:0
        pageSize=pageSize?:10
        val esProductPage = esProductService.search(keyword, brandId, productCategoryId, pageNum, pageSize, 1)
        //return CommonPage.reset(esProductPage)
        return null
    }
}