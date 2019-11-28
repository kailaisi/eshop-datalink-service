package com.kailaisi.eshopdatalinkservice.repository

import com.kailaisi.eshopdatalinkservice.model.qo.MemberReadHistory
import org.springframework.data.mongodb.repository.MongoRepository

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/11/28 15:59
 */
interface MemberReadHistoryRepository : MongoRepository<MemberReadHistory, String> {
    /**
     * 根据会员id按时间倒序获取浏览记录
     * @param memberId 会员id
     */
    fun findByMemberIdOrderByCreateTimeDesc(memberId: Long): List<MemberReadHistory>
}