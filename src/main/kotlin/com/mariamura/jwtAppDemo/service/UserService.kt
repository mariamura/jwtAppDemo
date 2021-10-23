package com.mariamura.jwtAppDemo.service

import com.mariamura.jwtAppDemo.model.User
import com.mariamura.jwtAppDemo.repository.impl.UserRepositoryImpl

class UserService(userRepository: UserRepositoryImpl) {
    private val userRepository: UserRepositoryImpl

    init {
        this.userRepository = userRepository
    }

    fun getAll() {
        userRepository.all
    }
    fun getById(id: Int?): User? {
        return userRepository.getById(id)
    }

    fun save(user: User?): User? {
        return userRepository.save(user)
    }

    fun update(user: User?): User? {
        return userRepository.update(user)
    }

    fun deleteById(id: Int?) {
        userRepository.deleteById(id)
    }
}