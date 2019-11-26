package com.kailaisi.eshopdatalinkservice.search

import com.kailaisi.eshopdatalinkservice.search.domain.EsProduct
import com.kailaisi.eshopdatalinkservice.search.domain.EsProductRelatedInfo
import org.springframework.data.domain.Page

/**
 *描述：商品搜索管理
 *<p/>作者：wu
 *<br/>创建时间：2019/11/26 10:43
 */
interface EsProductService {

    /**
     * 从数据库中导入所有商品到ES
     */
    fun importAll(): Int

    /**
     * 根据id删除商品
     */
    fun delete(id: Long)

    /**
     * 根据id创建商品
     */
    fun create(id: Long): EsProduct?

    /**
     * 批量删除商品
     */
    fun delete(ids: List<Long>)

    /**
     * 根据关键字搜索名称或者副标题
     */
    fun search(keyword: String, pageNum: Int, pageSize: Int): Page<EsProduct>?

    /**
     * 根据关键字搜索名称或者副标题复合查询
     */
    fun search(keyword: String, brandId: Long?, productCategoryId: Long?, pageNum: Int, pageSize: Int, sort: Int): Page<EsProduct>

    /**
     * 根据商品id推荐相关商品
     */
    fun recommend(id: Long, pageNum: Int, pageSize: Int): Page<EsProduct>

    /**
     * 获取搜索词相关品牌、分类、属性
     */
    fun searchRelatedInfo(keyword: String): EsProductRelatedInfo
}