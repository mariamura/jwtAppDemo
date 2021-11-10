package com.mariamura.jwtAppDemo.service

import com.mariamura.jwtAppDemo.model.User

interface UserService {

    fun register(user: User): User

    fun getAll(): List<User>

    fun findById(id: Long): User

    fun findByUsername(username: String): User

    fun delete(id: Long)
}