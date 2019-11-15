package com.kailaisi.eshopdatalinkservice.model

/**
 *描述：静态常量
 *<p/>作者：wu
 *<br/>创建时间：2019/11/6 21:05
 */
object HeaderConstants{
    val CALL_SOURCE="CALL_SOURCE"
    val APP_VERSION="APP_VERSION"
    val API_VERSION="API_VERSION"
}

enum class CallSourceEnum {
    /**
     * WEB网站
     */
    WEB,
    /**
     * PC客户端
     */
    PC,
    /**
     * 微信公众号
     */
    WECHAT,
    /**
     * IOS平台
     */
    IOS,
    /**
     * 安卓平台
     */
    ANDROID;

    companion object {
        fun isValid(name: String): Boolean {
            for (callSource in CallSourceEnum.values()) {
                if (callSource.name == name) {
                    return true
                }
            }
            return false
        }
    }
}
