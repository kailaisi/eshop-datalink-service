package com.kailaisi.eshopdatalinkservice.search.domain

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.io.Serializable
import java.math.BigDecimal

/**
 *描述：搜索中的商品信息
 *<p/>作者：wu
 *<br/>创建时间：2019/11/26 11:26
 */
@Document(indexName = "pms", type = "product", shards = 1, replicas = 0)
class EsProduct : Serializable {
    val serialVersionUID = -1L
    @Id
    var id: Long = 0
    @Field(type = FieldType.Keyword)
    var productSn: String? = null
    var brandId: Long? = null
    @Field(type = FieldType.Keyword)
    var brandName: String? = null
    var productCategoryId: Long? = null
    @Field(type = FieldType.Keyword)
    var productCategoryName: String? = null
    var pic: String? = null
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    var name: String? = null
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    var subTitle: String? = null
    @Field(analyzer = "ik_max_word", type = FieldType.Text)
    var keywords: String? = null
    var price: BigDecimal? = null
    var sale: Int? = null
    var newStatus: Int? = null
    var recommandStatus: Int? = null
    var stock: Int? = null
    var promotionType: Int? = null
    var sort: Int? = null
    @Field(type = FieldType.Nested)
    var attrValueList: List<EsProductAttributeValue>? = null
}
