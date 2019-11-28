package com.kailaisi.eshopdatalinkservice.service

import com.kailaisi.eshopdatalinkservice.model.qo.MemberReadHistory

/**
*描述：浏览记录
*<p/>作者：wu
*<br/>创建时间：2019/11/28 15:32
*/
interface MemberReadHistoryService {
    fun create(memberReadHistory: MemberReadHistory)
    fun delete(ids: List<String>):Int
    fun list(memberId: Long):List<MemberReadHistory>
}
