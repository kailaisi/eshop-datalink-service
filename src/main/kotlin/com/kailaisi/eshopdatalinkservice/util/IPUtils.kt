package com.kailaisi.eshopdatalinkservice.util

import javax.servlet.http.HttpServletRequest

/**
 *描述：IP工具类
 *<p/>作者：wu
 *<br/>创建时间：2019/11/6 21:51
 */
object IPUtils {
    /**
     * 获取接口的调用地址
     */
    fun getRealIP(request: HttpServletRequest) = "${request.remoteAddr}:${request.remotePort}"

}
