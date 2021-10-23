package com.mariamura.jwtAppDemo.repository

import com.mariamura.jwtAppDemo.model.User

interface UserRepository {
    fun save(user: User?): User?

    fun getById(id: Int?): User?

    fun deleteById(id: Int?)

    val all: List<Any?>?

    fun update(user: User?): User?
}