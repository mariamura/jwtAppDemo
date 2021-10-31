package com.mariamura.jwtAppDemo.service.impl

import com.mariamura.jwtAppDemo.model.User
import com.mariamura.jwtAppDemo.repository.UserRepository
import com.mariamura.jwtAppDemo.repository.impl.RoleRepository
import com.mariamura.jwtAppDemo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository
    ) : UserService {

    override fun register(user: User): User {

    }

    override fun getAll(): List<User> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): User {
        TODO("Not yet implemented")
    }

    override fun getByUsername(username: String): User {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }
}