package com.kailaisi.eshopdatalinkservice.util

import com.kailaisi.eshopdatalinkservice.data.LoginToken
import com.kailaisi.eshopdatalinkservice.data.LoginUser
import org.apache.commons.codec.digest.DigestUtils
import java.util.*

/**
 *描述： 登录TOKEN辅助类
 *<p/>作者：wu
 *<br/>创建时间：2019/11/6 11:35
 */
object LoginTokenHelper {

    private val SECRET_KEY = "Ld4Dl5f9OoYTezPK"

    private val LOGIN_TOKEN_COOKIE_NAME = "X-Token"

    private val LOGIN_TOKEN_KEY = "LOGIN-TOKEN"

    /**
     * 获取登录的TOKEN的ID（取头信息或Cookie中）
     */
    val loginTokenId: String?
        get() {
            val request = RequestContextHolderUtil.request
            var token = request.getHeader(LOGIN_TOKEN_COOKIE_NAME)
            if (token.isNullOrEmpty()) {
                token = CookieUtil.getCookieValue(request, LOGIN_TOKEN_COOKIE_NAME, true)
            }
            return token
        }

    /**
     * 获取登录用户信息从请求对象 备注：使用该方法时需要在对应controller类或方法上加[LoginAuth]}注解
     */
    val loginUserFromRequest: LoginUser?
        get() {
            val loginToken = loginTokenFromRequest ?: return null
            return loginToken.loginUser
        }

    /**
     * 获取登录TOKEN信息从请求对象 备注：使用该方法时需要在对应controller类或方法上加[LoginAuth]}注解
     */
    val loginTokenFromRequest: LoginToken?
        get() {
            val loginTokenO = RequestContextHolderUtil.request.getAttribute(LOGIN_TOKEN_KEY) ?: return null
            return loginTokenO as LoginToken
        }

    /**
     * 根据登录的相关信息生成TOKEN ID
     */
    fun generateId(loginAccount: String, accountType: String, ip: String, platform: String, loginTime: Date, ttl: Long): String {
        val noEncodeLoginTokenId = StringBuilder(loginAccount)
                .append(accountType)
                .append(ip)
                .append(platform)
                .append(loginTime)
                .append(ttl)

        return DigestUtils.sha256Hex(SECRET_KEY + DigestUtils.md5Hex(noEncodeLoginTokenId.toString()) + DigestUtils.md5Hex(SECRET_KEY))
    }

    /**
     * 添加登录TOKEN的ID信息到COOKIE中
     */
    fun addLoginTokenIdToCookie(loginTokenId: String, expiredTimeSec: Int?) {
        val response = RequestContextHolderUtil.response
        CookieUtil.addCookie(response, LOGIN_TOKEN_COOKIE_NAME, loginTokenId, expiredTimeSec ?: -1, true)
    }

    /**
     * 清理登录账号信息从COOKIE中
     */
    fun delLoginTokenIdFromCookie() {
        val request = RequestContextHolderUtil.request
        val response = RequestContextHolderUtil.response
        CookieUtil.delCookie(request, response, LOGIN_TOKEN_COOKIE_NAME)
    }

    /**
     * 将登录TOKEN信息放入请求对象
     */
    fun addLoginTokenToRequest(loginToken: LoginToken) {
        RequestContextHolderUtil.request.setAttribute(LOGIN_TOKEN_KEY, loginToken)
    }

}
