package com.mariamura.jwtAppDemo.repository

import com.mariamura.jwtAppDemo.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByUsername(username: String): User
}