package com.kailaisi.eshopdatalinkservice.service.commonservice

/**
 *描述：通用的删除接口
 *<p/>作者：wu
 *<br/>创建时间：2019/11/14 16:32
 */
interface BaseDeleteService<PK> {
    /**
     * @return 影响的行数
     */
    fun deleteByPk(pk: PK): Int

    fun deleteByPks(list: Iterable<PK>): Int
}
