package com.mariamura.jwtAppDemo.security.jwt

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class JwtUser constructor(
    private val id: Long,
    private val username: String,
    private val password: String,
    private val enabled: Boolean,
    private val lastPasswordResetDate: Date,
    private val authorities: List<GrantedAuthority>
): UserDetails {

    override fun getAuthorities(): List<GrantedAuthority> {
        return authorities
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return enabled
    }

    @JsonIgnore
    fun getLastPasswordResetDate(): Date {
        return lastPasswordResetDate
    }

    @JsonIgnore
    fun getId(): Long {
        return id
    }
}