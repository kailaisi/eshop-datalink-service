package com.kailaisi.eshopdatalinkservice.model.enums

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/11/21 17:27
 */
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
        /**
         * 检验来源是否合法
         */
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

