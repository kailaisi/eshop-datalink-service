package com.kailaisi.eshopdatalinkservice.util

import org.springframework.web.util.WebUtils.getCookie
import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.net.URLEncoder
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 *描述：cookie辅助类
 *<p/>作者：wu
 *<br/>创建时间：2019/11/6 15:07
 */
object CookieUtil {
    /**
     * 删除cookie
     */
    fun delCookie(request: HttpServletRequest, response: HttpServletResponse?, name: String?) {
        if (name.isNullOrBlank()) {
            return
        }
        getCookie(request, name!!)?.apply {
            path = "/"
            value = ""
            maxAge = 0
            response?.addCookie(this)
        }
    }

    fun addCookie(response: HttpServletResponse?, name: String, value: String, maxAge: Int, isURLEncode: Boolean) {
        addCookie(response, name, value, -1)
    }

    /**
     * 添加cookie信息，指定生效时间
     *
     * secure属性
     * 当设置为true时，表示创建的 Cookie 会被以安全的形式向服务器传输，也就是只能在 HTTPS 连接中被浏览器传递到服务器端进行会话验证，如果是 HTTP 连接则不会传递该信息，所以不会被窃取到Cookie 的具体内容。
     * HttpOnly属性
     * 如果在Cookie中设置了"HttpOnly"属性，那么通过程序(JS脚本、Applet等)将无法读取到Cookie信息，这样能有效的防止XSS攻击。
     */
    fun addCookie(response: HttpServletResponse?, name: String, value: String, maxAge: Int = -1, isURLEncode: Boolean = false, isHttpOnly: Boolean = true, isSecure: Boolean = false) {
        try {
            val cookie = Cookie(name, if (isURLEncode) URLEncoder.encode(value, "UTF-8") else value)
            if (maxAge > 0) {
                cookie.maxAge = maxAge
            }

            cookie.path = "/"
            cookie.isHttpOnly = isHttpOnly
            cookie.secure = isSecure
            response?.addCookie(cookie)
        } catch (e: UnsupportedEncodingException) {
            TODO()
        }

    }

    /**
     * 获取对应的value值
     */
    fun getCookieValue(request: HttpServletRequest, name: String?, isDecode: Boolean = false): String? {
        if (name.isNullOrEmpty()) {
            return null
        }
        try {
            return getCookie(request, name!!)?.let {
                if (isDecode) URLDecoder.decode(it.value, "UTF-8") else it.value
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

}
