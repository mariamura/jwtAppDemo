package com.mariamura.jwtAppDemo.security.jwt

import com.mariamura.jwtAppDemo.model.Role
import com.mariamura.jwtAppDemo.model.Status
import com.mariamura.jwtAppDemo.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.util.stream.Collectors


object JwtUserFactory {
    fun create(user: User): JwtUser {
        return JwtUser(
            user.id,
            user.username,
            user.password,
            user.status == Status.ACTIVE,
            user.updated,
            mapToGrantedAuthorities(user.roles)
        )
    }

    private fun mapToGrantedAuthorities(userRoles: List<Role>): List<GrantedAuthority> {
        return userRoles.stream()
            .map { role: Role -> SimpleGrantedAuthority(role.name) }.collect(Collectors.toList())
    }
}