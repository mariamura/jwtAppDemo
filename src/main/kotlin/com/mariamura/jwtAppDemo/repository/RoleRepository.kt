package com.mariamura.jwtAppDemo.repository

import com.mariamura.jwtAppDemo.model.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<Role, Long> {
    fun findByName(username: String): Role
}