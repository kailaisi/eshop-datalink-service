package com.kailaisi.eshopdatalinkservice.model.enums

/**
 *描述：缓存的常量
 *<p/>作者：wu
 *<br/>创建时间：2019/11/21 17:27
 */
enum class CacheKeyEnum(var code: String, var sec: Int) {
    VALUE_LOGIN_TOKENS("login_tokens:", TimeEnum.ONE_HOUR.sec),
    VALUE_USERS("user:profile:%s", TimeEnum.ONE_WEEK.sec);
}
