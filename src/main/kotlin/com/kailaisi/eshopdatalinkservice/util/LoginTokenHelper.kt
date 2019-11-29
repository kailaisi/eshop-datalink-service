package com.kailaisi.eshopdatalinkservice.util

import com.kailaisi.eshopdatalinkservice.model.LoginToken
import com.kailaisi.eshopdatalinkservice.model.LoginUser
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

/**
 *描述： 登录TOKEN辅助类
 *<p/>作者：wu
 *<br/>创建时间：2019/11/6 11:35
 */
@Component
object LoginTokenHelper {

    var secret: String? = null
        @Value("\${jwt.secret}")
        set(value) {
            field = value
        }

    var expiration: Long = -1
        @Value("\${jwt.expiration}")
        set(value) {
            field = value
        }

    private val LOGGER = logger(this)

    private val CLAIM_KEY_USERID = "userid"

    private val CLAIM_KEY_CREATED = "created"

    private val SECRET_KEY = "Ld4Dl5f9OoYTezPK"
    /**
     * 请求中的header头，用于保存返回的token信息
     */
    private val LOGIN_TOKEN_COOKIE_NAME = "X-Token"
    /**
     * request中的用户信息
     */
    private val LOGIN_TOKEN_KEY = "LOGIN-TOKEN"

    /**
     * 从token中获取用户的id信息
     * 获取登录的TOKEN的ID（从header中获取token，然后进行jwt解密，获取id信息）
     */
    fun getLoginUserId(): Long? {
        val token = getToken()
        var userID:Long?=null
        if (!token.isNullOrEmpty()) {
            try {
                val claims = Jwts.parser()
                        .setSigningKey(secret)
                        .parseClaimsJws(token)
                        .body
                userID = claims[CLAIM_KEY_USERID] as Long?
            } catch (e: Exception) {

            }
        }
        return userID
    }

    fun getToken(): String? {
        val request = RequestContextHolderUtil.request
        return request.getHeader(LOGIN_TOKEN_COOKIE_NAME)
    }

    /**
     * 获取登录用户信息从请求对象 备注：使用该方法时需要在对应controller类或方法上加[LoginAuth]}注解
     */
    val loginUserFromRequest: LoginUser?
        get() {
            val loginToken = getLoginTokenFromRequest() ?: return null
            return loginToken.loginUser
        }

    /**
     * 根据登录token的bean类生成token值信息
     */
    fun generateToken(loginAccount: LoginToken): String {
        var map = mutableMapOf<String, Any>()
        map[CLAIM_KEY_USERID] = loginAccount.loginUser!!.id
        map[CLAIM_KEY_CREATED] = loginAccount.createTime
        return Jwts.builder()
                .setClaims(map)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact()
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
     * 将登录TOKEN信息放入请求对象，在拦截器中，将token的信息放入到setAttribute属性之中
     */
    fun addLoginTokenToRequest(loginToken: LoginToken) {
        RequestContextHolderUtil.request.setAttribute(LOGIN_TOKEN_KEY, loginToken)
    }

    /**
     * 获取登录TOKEN信息从请求对象 备注：使用该方法时需要在对应controller类或方法上加[LoginAuth]}注解
     */
    fun getLoginTokenFromRequest(): LoginToken? {
        val loginTokenO = RequestContextHolderUtil.request.getAttribute(LOGIN_TOKEN_KEY) ?: return null
        return loginTokenO as LoginToken
    }

}
