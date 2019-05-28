package com.kailaisi.eshopdatalinkservice.service

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/5/24 14:44
 */
interface CacheService {
    fun getProductInfo(id: Long): String?
    fun putProductInfo(id: Long, info: String): String
}

