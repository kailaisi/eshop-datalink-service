package com.kailaisi.eshopdatalinkservice.mgb

import java.util.*

/**
 * 描述：所有生成的mapper类都继承该方法
 *
 * 作者：wu
 * <br></br>创建时间：2019/11/16 16:14
 */
abstract class BasePO<PK> : Model {
    abstract fun getId(): PK
    abstract fun setId(pk: PK)
    abstract fun getCreateTime(): Date?
    abstract fun setCreateTime(date: Date?)
    abstract fun getUpdateTime(): Date?
    abstract fun setUpdateTime(date: Date?)
}
