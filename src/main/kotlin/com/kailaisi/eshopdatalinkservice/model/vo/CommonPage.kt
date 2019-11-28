package com.kailaisi.eshopdatalinkservice.model.vo

import com.github.pagehelper.Page
import com.github.pagehelper.PageInfo
import com.kailaisi.eshopdatalinkservice.mgb.Model
import com.kailaisi.eshopdatalinkservice.model.qo.PageQO
import com.kailaisi.eshopdatalinkservice.search.domain.EsProduct
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.springframework.beans.BeanUtils
import kotlin.math.ceil

/**
 * 分页数据封装类
 * Created by wu on 2019/4/19.
 */
@ApiModel("分页返回数据集")
class CommonPage<T>():Model {
    @ApiModelProperty("当前页号")
    var pageNum: Int = 0
    @ApiModelProperty("每页的数量")
    var pageSize: Int = 0
    @ApiModelProperty("总页数")
    var totalPage: Int = 0
    @ApiModelProperty("总记录数")
    var total: Long = 0L
    @ApiModelProperty("结果集")
    var list: List<T>? = null

    constructor(pageQO: PageQO<*>) : this() {
        pageNum = pageQO.pageNum
        pageSize = pageQO.pageSize
    }

    constructor(poList: List<T>) : this() {
        BeanUtils.copyProperties(PageInfo(poList), this)
    }

    fun getPages() {
        getPage(total!!, pageSize!!)
    }

    companion object {
        /**
         * 将PageHelper分页后的list转为分页信息
         * @param list 数据库查询出来的分页数据列表
         */
        fun <T> build(list: List<T>): CommonPage<T> {
            return CommonPage(list)
        }

        /**
         * 将PageHelper分页后的list转为分页信息
         * 使用场景：直接从数据库查询出来的列表，不做任何处理，直接转化为Vo列表进行返回
         * @param page 数据库查出来的分页数据列表
         * @param voClazz 要转为的VO类
         */
        fun <T, E> build(page: Page<E>, clazz: Class<T>): CommonPage<T> {
            var commonPage = CommonPage<T>()
            BeanUtils.copyProperties(page, commonPage, "list")
            val list = mutableListOf<T>()
            try {
                page.result?.forEach {
                    val instance = clazz.newInstance()!!
                    BeanUtils.copyProperties(it!!, instance)
                    list.add(instance)
                }
                commonPage.list = list
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
            return commonPage
        }

        /**
         * @desc 构建一个分页VO对象
         * 试用场景为：将处理好的VO列表封装返回
         *
         * @param poPage 数据库查出来的分页数据
         * @param voList vo数据列表
         */
        fun <E, T> build(page: Page<E>, voList: List<T>?): CommonPage<*> {
            return CommonPage<T>().apply {
                BeanUtils.copyProperties(page, this, "list")
                list = voList ?: mutableListOf()
            }
        }

        fun getPage(total: Long, pageSize: Int): Int {
            if (total == 0L || pageSize == 0) {
                return 0
            } else {
                return ceil(total.toDouble().div(pageSize)) as Int
            }
        }

        fun<T> reset(pageInfo: org.springframework.data.domain.Page<T>): CommonPage<T> {
            val result: CommonPage<T> = CommonPage()
            result.apply {
                totalPage=pageInfo.totalPages
                pageNum=pageInfo.number
                pageSize=pageInfo.size
                total=pageInfo.totalElements
                list=pageInfo.content
            }
            return result
        }
    }
}
