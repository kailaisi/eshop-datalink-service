package com.kailaisi.eshopdatalinkservice.service

interface UmsMemberService {
    fun generateAuthCode(phone: String): String
    fun verifyAuthCode(phone: String, authCode: String?): String
}
