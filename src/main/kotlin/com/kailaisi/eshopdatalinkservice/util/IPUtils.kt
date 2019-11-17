package com.kailaisi.eshopdatalinkservice.util

import jdk.nashorn.internal.runtime.regexp.joni.Config.log
import java.net.InetAddress
import java.net.NetworkInterface
import java.net.UnknownHostException
import java.util.*
import java.util.regex.Pattern
import javax.servlet.http.HttpServletRequest

/**
 *描述：IP工具类
 *<p/>作者：wu
 *<br/>创建时间：2019/11/6 21:51
 */
object IPUtils {
    val log= logger(this)
    private val IP_PATTERN = "^(?:(?:[01]?\\d{1,2}|2[0-4]\\d|25[0-5])\\.){3}(?:[01]?\\d{1,2}|2[0-4]\\d|25[0-5])\\b"

    private val UNKNOWN = "unknown"

    private val LOOPBACK_ADDRESS = "127.0.0.1"

    private val UNKNOWN_ADDRESS = "0:0:0:0:0:0:0:1"

    /**
     * @Description: 获取请求中的ip地址：过了多级反向代理，获取的ip不是唯一的，二是包含中间代理层ip。
     *
     * @return 可能有多个，例如：192.168.1.110， 192.168.1.120
     */
    fun getIpAddr(request: HttpServletRequest?): String? {
        var ip: String? = "127.0.0.1"
        if (request != null) {
            ip = request.getHeader("x-forwarded-for")
            if (ip.isNullOrEmpty() || UNKNOWN.equals(ip, ignoreCase = true)) {
                ip = request.getHeader("Proxy-Client-IP")
            }

            if (ip.isNullOrEmpty() || UNKNOWN.equals(ip, ignoreCase = true)) {
                ip = request.getHeader("WL-Proxy-Client-IP")
            }

            if (ip.isNullOrEmpty() || UNKNOWN.equals(ip, ignoreCase = true)) {
                ip = request.remoteAddr
            }
        }
        return ip
    }

    /**
     *
     * @Description: 获取客户端请求中的真实的ip地址
     *
     * 获取客户端的IP地址的方法是：request.getRemoteAddr()，这种方法在大部分情况下都是有效的。
     * 但是在通过了Apache，Squid等反向代理软件就不能获取到客户端的真实IP地址。而且，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，
     * 而是一串ip值，例如：192.168.1.110， 192.168.1.120， 192.168.1.130， 192.168.1.100。其中第一个192.168.1.110才是用户真实的ip
     */
    fun getRealIp(request: HttpServletRequest?): String? {
        var ip: String? = LOOPBACK_ADDRESS
        if (request == null) {
            return ip
        }
        ip = request.getHeader("x-forwarded-for")
        if (ip.isNullOrEmpty() || UNKNOWN.equals(ip, ignoreCase = true)) {
            ip = request.getHeader("Proxy-Client-IP")
        }
        if (ip.isNullOrEmpty() || UNKNOWN.equals(ip, ignoreCase = true)) {
            ip = request.getHeader("WL-Proxy-Client-IP")
        }
        if (ip.isNullOrEmpty() || UNKNOWN.equals(ip, ignoreCase = true)) {
            ip = request.getHeader("HTTP_CLIENT_IP")
        }
        if (ip.isNullOrEmpty() || UNKNOWN.equals(ip, ignoreCase = true)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR")
        }
        if (ip.isNullOrEmpty() || UNKNOWN.equals(ip, ignoreCase = true)) {
            ip = request.remoteAddr
            if (LOOPBACK_ADDRESS == ip || UNKNOWN_ADDRESS == ip) {
                //根据网卡取本机配置的IP
                try {
                    val inet = InetAddress.getLocalHost()
                    ip = inet.hostAddress
                } catch (e: UnknownHostException) {
                    log.error("getRealIp occurs error, caused by: ", e)
                }

            }
        }
        //"***.***.***.***".length() = 15
        val ipLength = 15
        val separator = ","
        if (ip != null && ip.length > ipLength) {
            if (ip.indexOf(separator) > 0) {
                ip = ip.substring(0, ip.indexOf(","))
            }
        }
        return ip
    }

    fun getServiceIp(): String {
        var netInterfaces: Enumeration<NetworkInterface>?
        var ipsStr = ""

        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces()
            while (netInterfaces!!.hasMoreElements()) {
                val ni = netInterfaces.nextElement()
                val ips = ni.inetAddresses
                val pattern = Pattern.compile(IP_PATTERN)
                while (ips.hasMoreElements()) {
                    val ip = ips.nextElement().hostAddress
                    val matcher = pattern.matcher(ip)
                    if (matcher.matches() && "127.0.0.1" != ip) {
                        ipsStr = ip
                    }
                }
            }
        } catch (e: Exception) {
            log.error("getServiceIp occurs error, caused by: ", e)
        }

        return ipsStr
    }
}
