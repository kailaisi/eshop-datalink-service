package com.kailaisi.eshopdatalinkservice.model.qo

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
*描述：分页查询请求对象
*<p/>作者：wu
*<br/>创建时间：2019/11/18 9:09
*/
@ApiModel("分页查询对象")
class PageQO<T>(var pageNum: Int = 0, var pageSize: Int = 10) {
    @ApiModelProperty(value = "排序", notes = "例：create_time desc,update_time desc")
    var orderBy: String? = null
    /**
     * 按创建时间倒序排序
     */
    val ORDER_BY_CREATE_TIME_DESC = "create_time desc"
    var condition: T? = null

    fun getOffset(): Int = (pageNum - 1).times(pageSize)
}
