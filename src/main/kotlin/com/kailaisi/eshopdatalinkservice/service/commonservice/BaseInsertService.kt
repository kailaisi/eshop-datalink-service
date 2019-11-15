package com.kailaisi.eshopdatalinkservice.service.commonservice

interface BaseInsertService<E, PK> {
    /**
     * 增加一条数据
     * @return 添加后的主键
     */
    fun insert(e: E): PK
}
