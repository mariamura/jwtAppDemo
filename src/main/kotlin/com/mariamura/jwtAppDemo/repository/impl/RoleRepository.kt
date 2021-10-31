package com.mariamura.jwtAppDemo.repository.impl

import com.mariamura.jwtAppDemo.model.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<Role, Long> {
    fun findByName(username: String): Role
}