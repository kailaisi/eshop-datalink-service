package com.kailaisi.eshopdatalinkservice.service.commonservice

import com.kailaisi.eshopdatalinkservice.dto.CommonPage

/**
 *描述：通用的查询接口
 *<p/>作者：wu
 *<br/>创建时间：2019/11/14 15:45
 */
interface BaseSelectService<E, PK> {
    /**
     * 根据主键查询
     * @return 查询结果,无结果时返回{ @code null}
     */
    fun selectByPk(pk: PK): E?

    /**
     * 根据多个主键查询
     * @return 查询结果,如果无结果返回空集合
     */
    fun selectByPks(list: List<PK>): List<E>

    /**
     * 查询所有的信息
     * @return 查询结果,如果无结果返回空集合
     */
    fun selectAll(): List<E>

    /**
     * 查询所有结果
     * @return 获取分页结果
     */
    fun selectPage(): CommonPage<*>
}
