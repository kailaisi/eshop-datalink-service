package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.model.qo.MemberReadHistory
import com.kailaisi.eshopdatalinkservice.repository.MemberReadHistoryRepository
import com.kailaisi.eshopdatalinkservice.service.MemberReadHistoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

/**
 *描述：用户浏览记录
 *<p/>作者：wu
 *<br/>创建时间：2019/11/28 15:57
 */
@Service
class MemberReadHistoryServiceImpl : MemberReadHistoryService {
    @Autowired
    lateinit var memberReadHistoryRepository: MemberReadHistoryRepository

    override fun create(memberReadHistory: MemberReadHistory) {
        memberReadHistory.id = null
        memberReadHistory.createTime = Date()
        memberReadHistoryRepository.save(memberReadHistory)
    }

    override fun delete(ids: List<String>): Int {
        val list = ids.map {
            MemberReadHistory().apply {
                id = it
            }
        }.toCollection(mutableListOf())
        memberReadHistoryRepository.deleteAll(list)
        return ids.size
    }

    override fun list(memberId: Long): List<MemberReadHistory> {
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId)
    }
}