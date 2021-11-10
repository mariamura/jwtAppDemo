package com.mariamura.jwtAppDemo.security

import com.mariamura.jwtAppDemo.model.User
import com.mariamura.jwtAppDemo.security.jwt.JwtUserFactory.create
import com.mariamura.jwtAppDemo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

class JwtUserDetailsService @Autowired constructor(
    private val userService: UserService
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val user: User
        if (username != null) {
            user = userService.findByUsername(username)
        } else throw UsernameNotFoundException("user ${username} not found")
        return create(user)
    }
}