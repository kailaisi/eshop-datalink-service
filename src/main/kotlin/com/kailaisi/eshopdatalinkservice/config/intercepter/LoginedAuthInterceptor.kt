package com.kailaisi.eshopdatalinkservice.config.intercepter

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResultCode
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.service.UserLoginCacheService
import com.kailaisi.eshopdatalinkservice.util.LoginTokenHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 *描述：登录拦截，如果类或者方法上标注了{ @link LoginAuth}，则要求必须登录才可以通过
 *<p/>作者：wu
 *<br/>创建时间：2019/11/6 11:21
 */
@Component
class LoginedAuthInterceptor : HandlerInterceptor {
    @Autowired
    lateinit var userLoginCacheService: UserLoginCacheService

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (handler is HandlerMethod) {
            var beanType = handler.beanType
            var method = handler.method
            if (beanType.isAnnotationPresent(LoginAuth::class.java) || method.isAnnotationPresent(LoginAuth::class.java)) {
                //todo ("进行是否登录的校验,包括重定向的处理，token的获取处理等")
                val tokenId = LoginTokenHelper.loginTokenId
                if (tokenId.isNullOrEmpty()) {
                    throw BusinessException(ResultCode.USER_NOT_LOGGED_IN)
                }
                val loginToken = userLoginCacheService.getLoginUserById(tokenId!!)
                if (loginToken == null) {
                    throw BusinessException(ResultCode.USER_NOT_LOGGED_IN)
                }
                LoginTokenHelper.addLoginTokenToRequest(loginToken)
                return true
            }
        }
        return true
    }

}