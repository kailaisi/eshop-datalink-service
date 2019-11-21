package com.kailaisi.eshopdatalinkservice.model.enums

/**
 *描述：缓存的常量
 *<p/>作者：wu
 *<br/>创建时间：2019/11/21 17:27
 */
enum class CacheKeyEnum(var code: String, var sec: Int) {
    VALUE_LOGIN_TOKENS("zhuma:login_tokens:", TimeEnum.ONE_WEEK.sec),
    VALUE_USERS("zhuma:user:profile:%s", TimeEnum.ONE_WEEK.sec);
}
