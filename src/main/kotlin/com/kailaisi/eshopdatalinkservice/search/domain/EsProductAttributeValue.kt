package com.kailaisi.eshopdatalinkservice.search.domain

import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.io.Serializable

/**
 * 搜索中的商品属性信息
 * Created by macro on 2018/6/27.
 */
class EsProductAttributeValue : Serializable {
    var id: Long? = null
    var productAttributeId: Long? = null
    //属性值
    @Field(type = FieldType.Keyword)
    var value: String? = null
    //属性参数：0->规格；1->参数
    var type: Int? = null
    //属性名称
    @Field(type = FieldType.Keyword)
    var name: String? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}