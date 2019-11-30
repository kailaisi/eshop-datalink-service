package com.kailaisi.eshopdatalinkservice.model.bo

/**
 *描述：记录日志的信息
 *<p/>作者：wu
 *<br/>创建时间：2019/11/30 20:23
 */
class WebLog {
    /**
     * 操作描述
     */
    var description: String? = null

    /**
     * 操作用户
     */
    var username: String? = null

    /**
     * 操作时间
     */
    var startTime: Long? = null

    /**
     * 消耗时间
     */
    var spendTime: Long? = null

    /**
     * 根路径
     */
    var basePath: String? = null

    /**
     * URI
     */
    var uri: String? = null

    /**
     * URL
     */
    var url: String? = null

    /**
     * 请求类型
     */
    var method: String? = null

    /**
     * IP地址
     */
    var ip: String? = null

    /**
     * 请求参数
     */
    var parameter: Any? = null

    /**
     * 请求返回的结果
     */
    var result: Any? = null
    /**
     * 数据来源
     */
    var callSource: String? = null
    /**
     * 协议版本号
     */
    var apiVersion: String? = null
    /**
     * 服务的版本号
     */
    var appVersion: String? = null
    /**
     *代理信息
     */
    var userAgent: String? = null
}
