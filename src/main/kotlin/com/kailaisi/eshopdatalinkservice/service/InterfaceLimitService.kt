package com.kailaisi.eshopdatalinkservice.service

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/12/9 17:41
 */
interface InterfaceLimitService {
    /**
     * 获取key对应的限量信息
     */
    fun getLimit(key: String): HashMap<String, Int>

    /**
     * 获取已经统计的数据
     */
    fun getCount(key: String): HashMap<String, Int>
}