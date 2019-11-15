package com.kailaisi.eshopdatalinkservice.service.commonservice

interface BaseUpdateService<E, PK> {
    /**
     * 修改
     * @return 影响的记录数
     */
    fun updateByPk(pk: PK,e:E):Int
    /**
     * 修改
     * @return 影响的记录数
     */
    fun updateByPkSelective(pk: PK,e:E):Int
    /**
     * 修改
     * @return 影响的记录数
     */
    fun saveOrUpdate(e:E):PK
}
