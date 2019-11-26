package com.kailaisi.eshopdatalinkservice.search

import com.kailaisi.eshopdatalinkservice.search.domain.EsProduct
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

/**
 *描述：商品ES操作类
 *<p/>作者：wu
 *<br/>创建时间：2019/11/26 10:36
 */
interface EsProductRepository :ElasticsearchRepository<EsProduct,Long>{
    /**
     * 搜索查询
     *
     * @param name              商品名称
     * @param subTitle          商品标题
     * @param keywords          商品关键字
     * @param page              分页信息
     * @return
     */
    fun findByNameOrSubTitleOrKeywords(name: String?, subTitle: String?, keywords: String?, page: Pageable?): Page<EsProduct>?
}