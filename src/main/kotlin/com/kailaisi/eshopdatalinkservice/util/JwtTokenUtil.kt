package com.kailaisi.eshopdatalinkservice.util

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*

/**
 * JwtToken生成的工具类
 * JWT token的格式：header.payload.signature
 * header的格式（算法、token的类型）：
 * {"alg": "HS512","typ": "JWT"}
 * payload的格式（用户名、创建时间、生成时间）：
 * {"sub":"wang","created":1489079981393,"exp":1489684781}
 * signature的生成算法：
 * HMACSHA512(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
 * Created by macro on 2018/4/26.
 */
@Component
class JwtTokenUtil {
    @Value("\${jwt.secret}")
    private val secret: String? = null
    @Value("\${jwt.expiration}")
    private val expiration: Long? = null

    /**
     * 根据负责生成JWT的token
     */
    private fun generateToken(claims: Map<String, Any>): String {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact()
    }

    /**
     * 从token中获取JWT中的负载
     */
    private fun getClaimsFromToken(token: String): Claims? {
        var claims: Claims? = null
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .body
        } catch (e: Exception) {
            LOGGER.info("JWT格式验证失败:{}", token)
        }

        return claims
    }

    /**
     * 生成token的过期时间
     */
    private fun generateExpirationDate(): Date {
        return Date(System.currentTimeMillis() + expiration!! * 1000)
    }

    /**
     * 从token中获取登录用户名
     */
    fun getUserNameFromToken(token: String): String? {
        var username: String?
        try {
            val claims = getClaimsFromToken(token)
            username = claims!!.subject
        } catch (e: Exception) {
            username = null
        }

        return username
    }

    /**
     * 验证token是否还有效
     *
     * @param token       客户端传入的token
     * @param userDetails 从数据库中查询出来的用户信息
     */
    fun validateToken(token: String, userDetails: UserDetails): Boolean {
        val username = getUserNameFromToken(token)
        return username == userDetails.username && !isTokenExpired(token)
    }

    /**
     * 判断token是否已经失效
     */
    private fun isTokenExpired(token: String): Boolean {
        val expiredDate = getExpiredDateFromToken(token)
        return expiredDate.before(Date())
    }

    /**
     * 从token中获取过期时间
     */
    private fun getExpiredDateFromToken(token: String): Date {
        val claims = getClaimsFromToken(token)
        return claims!!.expiration
    }

    /**
     * 根据用户信息生成token
     */
    fun generateToken(userDetails: UserDetails): String {
        val claims = HashMap<String, Any>()
        claims[CLAIM_KEY_USERNAME] = userDetails.username
        claims[CLAIM_KEY_CREATED] = Date()
        return generateToken(claims)
    }

    /**
     * 判断token是否可以被刷新
     */
    fun canRefresh(token: String): Boolean {
        return !isTokenExpired(token)
    }

    /**
     * 刷新token
     */
    fun refreshToken(token: String): String {
        val claims = getClaimsFromToken(token)
        claims!![CLAIM_KEY_CREATED] = Date()
        return generateToken(claims)
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(JwtTokenUtil::class.java)
        private val CLAIM_KEY_USERNAME = "sub"
        private val CLAIM_KEY_CREATED = "created"
    }
}
