package com.kailaisi.eshopdatalinkservice.search

import com.kailaisi.eshopdatalinkservice.search.domain.EsProduct
import com.kailaisi.eshopdatalinkservice.search.domain.EsProductRelatedInfo
import com.kailaisi.eshopdatalinkservice.search.domain.ProductAttr
import com.kailaisi.eshopdatalinkservice.util.logger
import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.common.lucene.search.function.FunctionScoreQuery
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder.FilterFunctionBuilder
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders.weightFactorFunction
import org.elasticsearch.search.aggregations.AbstractAggregationBuilder
import org.elasticsearch.search.aggregations.Aggregation
import org.elasticsearch.search.aggregations.AggregationBuilders
import org.elasticsearch.search.aggregations.bucket.filter.InternalFilter
import org.elasticsearch.search.aggregations.bucket.nested.InternalNested
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms
import org.elasticsearch.search.aggregations.bucket.terms.Terms
import org.elasticsearch.search.sort.SortBuilders
import org.elasticsearch.search.sort.SortOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate
import org.springframework.data.elasticsearch.core.ResultsExtractor
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils
import org.springframework.util.StringUtils
import java.util.*

/**
 *描述：商品搜索管理的实现类
 *<p/>作者：wu
 *<br/>创建时间：2019/11/26 10:45
 */
@Service
class EsProductServiceImpl : EsProductService {
    val log = logger(this)
    @Autowired
    lateinit var productDao: EsProductDao
    @Autowired
    lateinit var esProductRepository: EsProductRepository
    @Autowired
    lateinit var elasticsearchTemplate: ElasticsearchTemplate

    override fun importAll(): Int {
        val productList = productDao.getAllEsProductList(null)
        val iterable = esProductRepository.saveAll(productList)
        return iterable.count()
    }

    override fun delete(id: Long) {
        esProductRepository.deleteById(id)
    }

    override fun delete(ids: List<Long>) {
        if (!ids.isNullOrEmpty()) {
            val list = ids.map {
                EsProduct().apply {
                    id = it
                }
            }.toCollection(mutableListOf())
            esProductRepository.deleteAll(list)
        }
    }

    override fun create(id: Long): EsProduct? {
        var result: EsProduct? = null
        val productList = productDao.getAllEsProductList(id)
        productList.firstOrNull()?.let {
            result = esProductRepository.save(it)
        }
        return result
    }

    override fun search(keyword: String, pageNum: Int, pageSize: Int): Page<EsProduct>? {
        val request = PageRequest.of(pageNum, pageSize)
        return esProductRepository.findByNameOrSubTitleOrKeywords(keyword, keyword, keyword, request)
    }

    override fun search(keyword: String, brandId: Long?, productCategoryId: Long?, pageNum: Int, pageSize: Int, sort: Int): Page<EsProduct> {
        val request = PageRequest.of(pageNum, pageSize)
        val nativeSearchQueryBuilder = NativeSearchQueryBuilder()
        //分页
        nativeSearchQueryBuilder.withPageable(request)
        //过滤
        if (brandId != null || productCategoryId != null) {
            var boolQueryBuilder = QueryBuilders.boolQuery()
            brandId?.let { boolQueryBuilder.must(QueryBuilders.termQuery("brandId", it)) }
            productCategoryId?.let { boolQueryBuilder.must(QueryBuilders.termQuery("productCategoryId", it)) }
            nativeSearchQueryBuilder.withFilter(boolQueryBuilder)
        }
        //搜索
        if (keyword.isNullOrEmpty()) {
            nativeSearchQueryBuilder.withQuery(QueryBuilders.matchAllQuery())
        } else {
            val filterBuilder = mutableListOf<FunctionScoreQueryBuilder.FilterFunctionBuilder>()
            filterBuilder.add(FilterFunctionBuilder(QueryBuilders.matchQuery("name", keyword), weightFactorFunction(10f)))
            filterBuilder.add(FilterFunctionBuilder(QueryBuilders.matchQuery("subTitle", keyword), weightFactorFunction(5f)))
            filterBuilder.add(FilterFunctionBuilder(QueryBuilders.matchQuery("keywords", keyword), weightFactorFunction(2f)))
            var builders = filterBuilder.toTypedArray()
            val functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(builders)
                    .scoreMode(FunctionScoreQuery.ScoreMode.SUM)
                    .setMinScore(2f)
            nativeSearchQueryBuilder.withQuery(functionScoreQueryBuilder)
        }
        //排序
        //排序
        if (sort == 1) { //按新品从新到旧
            nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC))
        } else if (sort == 2) { //按销量从高到低
            nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("sale").order(SortOrder.DESC))
        } else if (sort == 3) { //按价格从低到高
            nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.ASC))
        } else if (sort == 4) { //按价格从高到低
            nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC))
        } else { //按相关度
            nativeSearchQueryBuilder.withSort(SortBuilders.scoreSort().order(SortOrder.DESC))
        }
        nativeSearchQueryBuilder.withSort(SortBuilders.scoreSort().order(SortOrder.DESC))
        val searchQuery = nativeSearchQueryBuilder.build()
        log.info("DSL:{}", searchQuery.query.toString())
        return esProductRepository.search(searchQuery)

    }

    override fun recommend(id: Long, pageNum: Int, pageSize: Int): Page<EsProduct> {
        val pageable: Pageable = PageRequest.of(pageNum, pageSize)
        val esProductList = productDao.getAllEsProductList(id)
        if (esProductList.size > 0) {
            val esProduct = esProductList[0]
            val keyword = esProduct.name
            val brandId = esProduct.brandId
            val productCategoryId = esProduct.productCategoryId
            //根据商品标题、品牌、分类进行搜索
            val filterFunctionBuilders: MutableList<FilterFunctionBuilder> = ArrayList()
            filterFunctionBuilders.add(FilterFunctionBuilder(QueryBuilders.matchQuery("name", keyword),
                    weightFactorFunction(8f)))
            filterFunctionBuilders.add(FilterFunctionBuilder(QueryBuilders.matchQuery("subTitle", keyword),
                    weightFactorFunction(2f)))
            filterFunctionBuilders.add(FilterFunctionBuilder(QueryBuilders.matchQuery("keywords", keyword),
                    weightFactorFunction(2f)))
            filterFunctionBuilders.add(FilterFunctionBuilder(QueryBuilders.matchQuery("brandId", brandId),
                    weightFactorFunction(10f)))
            filterFunctionBuilders.add(FilterFunctionBuilder(QueryBuilders.matchQuery("productCategoryId", productCategoryId),
                    weightFactorFunction(6f)))
            val builders = filterFunctionBuilders.toTypedArray()
            val functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(builders)
                    .scoreMode(FunctionScoreQuery.ScoreMode.SUM)
                    .setMinScore(2f)
            val builder = NativeSearchQueryBuilder()
            builder.withQuery(functionScoreQueryBuilder)
            builder.withPageable(pageable)
            val searchQuery = builder.build()
            log.info("DSL:{}", searchQuery.query.toString())
            return esProductRepository.search(searchQuery)
        }
        return PageImpl<EsProduct>(listOf())
    }

    override fun searchRelatedInfo(keyword: String): EsProductRelatedInfo {
        val builder = NativeSearchQueryBuilder()
        //搜索条件
        //搜索条件
        if (StringUtils.isEmpty(keyword)) {
            builder.withQuery(QueryBuilders.matchAllQuery())
        } else {
            builder.withQuery(QueryBuilders.multiMatchQuery(keyword, "name", "subTitle", "keywords"))
        }
        //聚合搜索品牌名称
        builder.addAggregation(AggregationBuilders.terms("brandNames").field("brandName"))
        //集合搜索分类名称
        builder.addAggregation(AggregationBuilders.terms("productCategoryNames").field("productCategoryName"))
        //聚合搜索商品属性，去除type=1的属性
        val aggregationBuilder: AbstractAggregationBuilder<*> = AggregationBuilders.nested("allAttrValues", "attrValueList")
                .subAggregation(AggregationBuilders.filter("productAttrs", QueryBuilders.termQuery("attrValueList.type", 1))
                        .subAggregation(AggregationBuilders.terms("attrIds")
                                .field("attrValueList.productAttributeId")
                                .subAggregation(AggregationBuilders.terms("attrValues")
                                        .field("attrValueList.value"))
                                .subAggregation(AggregationBuilders.terms("attrNames")
                                        .field("attrValueList.name"))))
        builder.addAggregation(aggregationBuilder)
        val searchQuery = builder.build()
        return elasticsearchTemplate.query(searchQuery, ResultsExtractor<EsProductRelatedInfo> {
            convertProductRelatedInfo(it)
        })
    }

    /**
     * 将返回结果转换为对象
     */
    private fun convertProductRelatedInfo(response: SearchResponse): EsProductRelatedInfo? {
        val productRelatedInfo = EsProductRelatedInfo()
        val aggregationMap = response.aggregations.asMap
        //设置品牌
        val brandNames = aggregationMap["brandNames"]
        val brandNameList: MutableList<String> = ArrayList()
        (brandNames as Terms?)?.buckets?.forEach {
            brandNameList.add(it.keyAsString)
        }
        productRelatedInfo.brandNames = brandNameList
        //设置分类
        val productCategoryNames = aggregationMap["productCategoryNames"]
        val productCategoryNameList: MutableList<String> = ArrayList()
        (productCategoryNames as Terms?)?.buckets?.forEach {
            productCategoryNameList.add(it.keyAsString)
        }
        productRelatedInfo.productCategoryNames = productCategoryNameList
        //设置参数
        val productAttrs = aggregationMap["allAttrValues"]
        val attrIds = (((productAttrs as InternalNested?)!!.getProperty("productAttrs") as InternalFilter).getProperty("attrIds") as LongTerms).buckets
        val attrList: MutableList<ProductAttr> = ArrayList<ProductAttr>()
        for (attrId in attrIds) {
            val attr = ProductAttr()
            attr.attrId = attrId.key as Long
            val attrValueList: MutableList<String> = ArrayList()
            val attrValues = (attrId.aggregations.get<Aggregation>("attrValues") as StringTerms).buckets
            val attrNames = (attrId.aggregations.get<Aggregation>("attrNames") as StringTerms).buckets
            for (attrValue in attrValues) {
                attrValueList.add(attrValue.keyAsString)
            }
            attr.attrValues = attrValueList
            if (!CollectionUtils.isEmpty(attrNames)) {
                val attrName = attrNames[0]!!.keyAsString
                attr.attrName = attrName
            }
            attrList.add(attr)
        }
        productRelatedInfo.productAttrs = attrList
        return productRelatedInfo
    }
}