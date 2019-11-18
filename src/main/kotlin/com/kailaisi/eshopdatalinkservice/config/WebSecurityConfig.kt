package com.kailaisi.eshopdatalinkservice.config

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResultCode
import com.kailaisi.eshopdatalinkservice.config.intercepter.result.exception.BusinessException
import com.kailaisi.eshopdatalinkservice.service.UmsAdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.Filter


/**
 *描述：Security的授权和鉴权配置信息
 *<p/>作者：wu
 *<br/>创建时间：2019/11/18 14:51
 */
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var adminService: UmsAdminService
    @Autowired
    lateinit var restfulAccessDeniedHandler: RestfulAccessDeniedHandler
    @Autowired
    lateinit var restAuthenticationEntryPoint: RestAuthenticationEntryPoint

    override fun configure(http: HttpSecurity) {
        http.csrf()//由于使用的是JWT，我们这里不需要csrf
                .disable()
                .sessionManagement()//基于token，不需要session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,//允许对静态网站的访问
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**")
                .permitAll()
                .antMatchers("/admin/login", "/admin/register")//对于登录和注册接口允许匿名访问
                .permitAll()
                .anyRequest()//其他的所有的都需要进行鉴权认证
                .authenticated()
        //禁用缓存
        http.headers().cacheControl()
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter::class.java)
        //添加自定义未授权和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint)
    }

    @Bean
    fun jwtAuthenticationTokenFilter(): Filter = JwtAuthenticationTokenFilter()

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder())
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    @Bean
    public override fun userDetailsService(): UserDetailsService {
        //获取登录用户信息
        return object : UserDetailsService {
            override fun loadUserByUsername(name: String?): UserDetails {
                val list = adminService.getAdminByUserName(name!!)
                if (list != null && list.isNotEmpty()) {
                    return AdminUserDetails(list[0])
                } else {
                    throw BusinessException(ResultCode.USER_LOGIN_ERROR)
                }
            }

        }
    }

}