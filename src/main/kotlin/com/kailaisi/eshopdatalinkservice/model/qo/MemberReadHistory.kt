package com.kailaisi.eshopdatalinkservice.model.qo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

/**
 * 用户商品浏览历史记录
 * Created by macro on 2018/8/3.
 */
@Document
class MemberReadHistory {
    //省略了所有getter和setter方法
    @Id
    var id: String? = null
    @Indexed
    var memberId: Long=0
    var memberNickname: String? = null
    var memberIcon: String? = null
    @Indexed
    var productId: Long? = null
    var productName: String? = null
    var productPic: String? = null
    var productSubTitle: String? = null
    var productPrice: String? = null
    var createTime: Date? = null
}