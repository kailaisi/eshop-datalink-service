package com.kailaisi.eshopdatalinkservice.mgb

import java.io.Serializable
import java.util.*

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/11/16 16:16
 */
open interface Model<PK> : Serializable {
    fun getId(): PK
    fun setId(pk: PK)
    fun getCreateTime(): Date?
    fun setCreateTime(date: Date?)
    fun getUpdateTime(): Date?
    fun setUpdateTime(date: Date?)
}