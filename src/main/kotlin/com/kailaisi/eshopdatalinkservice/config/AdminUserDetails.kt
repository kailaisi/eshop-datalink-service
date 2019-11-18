package com.kailaisi.eshopdatalinkservice.config

import com.kailaisi.eshopdatalinkservice.mgb.model.UmsAdmin
import com.kailaisi.eshopdatalinkservice.mgb.model.UmsPermission
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors

/**
 *描述：SpringSecurity需要的用户详情
 *<p/>作者：wu
 *<br/>创建时间：2019/11/18 15:29
 */
class AdminUserDetails(var admin: UmsAdmin, var permissionList: List<UmsPermission>?=null) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        if (permissionList == null) {
            return mutableListOf(SimpleGrantedAuthority("TEST"))
        } else {
            return permissionList!!.stream()
                    .filter { it.value != null }
                    .map { SimpleGrantedAuthority(it.value) }
                    .collect(Collectors.toList())
        }
    }

    override fun isEnabled(): Boolean = admin.status == 1

    override fun getUsername(): String {
        return admin.username
    }

    override fun isCredentialsNonExpired(): Boolean = true

    override fun getPassword(): String {
        return admin.password
    }

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

}
