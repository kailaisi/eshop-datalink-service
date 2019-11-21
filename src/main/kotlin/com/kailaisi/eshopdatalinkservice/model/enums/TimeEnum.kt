package com.kailaisi.eshopdatalinkservice.model.enums

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/11/21 17:12
 */
enum class TimeEnum(var sec: Int) {

    /**
     * 一分钟
     */
    ONE_MINUTES(60),
    /**
     * 一小时
     */
    ONE_HOUR(60 * 60),
    /**
     * 一天
     */
    ONE_DAY(24 * 60 * 60),
    /**
     * 一周
     */
    ONE_WEEK(7 * 24 * 60 * 60),
    /**
     * 一个月
     */
    ONE_MONTH(30 * 24 * 60 * 60)
}