package com.kailaisi.eshopdatalinkservice.search.domain

/**
 *描述：搜索相关商品品牌名称，分类名称及属性
 *<p/>作者：wu
 *<br/>创建时间：2019/11/26 16:57
 */
class EsProductRelatedInfo {
    var brandNames: List<String>? = null
    var productCategoryNames: List<String>? = null
    var productAttrs: List<ProductAttr>? = null
}

class ProductAttr {
    var attrId: Long? = null
    var attrName: String? = null
    var attrValues: List<String>? = null
}