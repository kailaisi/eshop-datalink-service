package com.kailaisi.eshopdatalinkservice.dto

import com.github.pagehelper.Page
import com.github.pagehelper.PageInfo

/**
 * 分页数据封装类
 * Created by wu on 2019/4/19.
 */
class CommonPage<T> {
    var pageNum: Int? = null
    var pageSize: Int? = null
    var totalPage: Int? = null
    var total: Long? = null
    var list: List<T>? = null

    companion object {
        /**
         * 将PageHelper分页后的list转为分页信息
         */
        fun <T> restPage(list: List<T>): CommonPage<T> {
            val result = CommonPage<T>()
            val pageInfo = PageInfo(list)
            result.totalPage = pageInfo.pages
            result.pageNum = pageInfo.pageNum
            result.pageSize = pageInfo.pageSize
            result.total = pageInfo.total
            result.list = pageInfo.list
            return result
        }
/*
        *//**
         * 将SpringData分页后的list转为分页信息
         *//*
        fun <T> restPage(pageInfo: Page<T>): CommonPage<T> {
            val result = CommonPage<T>()
            result.totalPage = pageInfo.totalPages
            result.pageNum = pageInfo.number
            result.pageSize = pageInfo.size
            result.total = pageInfo.totalElements
            result.list = pageInfo.content
            return result
        }*/

        fun <E> build(page: Page<E>?): CommonPage<*> {
            return CommonPage<E>()
        }
    }
}
