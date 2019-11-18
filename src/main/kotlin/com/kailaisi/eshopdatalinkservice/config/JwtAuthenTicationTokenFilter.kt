package com.kailaisi.eshopdatalinkservice.config

import com.kailaisi.eshopdatalinkservice.util.JwtTokenUtil
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 *描述：JWT登录授权过滤器
 *<p/>作者：wu
 *<br/>创建时间：2019/11/18 15:34
 */
class JwtAuthenticationTokenFilter : OncePerRequestFilter() {
    private val LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter::class.java)
    @Autowired
    lateinit var userDetailsService: UserDetailsService
    @Autowired
    lateinit var jwtTokenUtil: JwtTokenUtil
    @Value("\${jwt.tokenHeader}")
    lateinit var tokenHeader: String
    @Value("\${jwt.tokenHead}")
    lateinit var tokenHead: String

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest,
                                  response: HttpServletResponse,
                                  chain: FilterChain) {
        val authHeader = request.getHeader(this.tokenHeader)
        if (authHeader != null && authHeader.startsWith(this.tokenHead)) {
            val authToken = authHeader.substring(this.tokenHead.length)// The part after "Bearer "
            val username = jwtTokenUtil.getUserNameFromToken(authToken)
            LOGGER.info("checking username:{}", username)
            if (username != null && SecurityContextHolder.getContext().authentication == null) {
                val userDetails = this.userDetailsService.loadUserByUsername(username)
                if (jwtTokenUtil!!.validateToken(authToken, userDetails)) {
                    val authentication = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
                    authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                    LOGGER.info("authenticated user:{}", username)
                    SecurityContextHolder.getContext().authentication = authentication
                }
            }
        }
        chain.doFilter(request, response)
    }

}
