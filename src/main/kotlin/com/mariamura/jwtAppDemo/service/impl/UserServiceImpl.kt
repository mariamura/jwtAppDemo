package com.mariamura.jwtAppDemo.service.impl

import com.mariamura.jwtAppDemo.model.Role
import com.mariamura.jwtAppDemo.model.Status
import com.mariamura.jwtAppDemo.model.User
import com.mariamura.jwtAppDemo.repository.UserRepository
import com.mariamura.jwtAppDemo.repository.impl.RoleRepository
import com.mariamura.jwtAppDemo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service


@Service
class UserServiceImpl @Autowired constructor(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder
    ) : UserService {

    override fun register(user: User): User {
        val roleUser = roleRepository.findByName("ROLE_USER")
        val userRoles: List<Role> = listOf(roleUser)

        val registerUser: User =  user.copy(
            password = bCryptPasswordEncoder.encode(user.password),
            roles = userRoles,
            status = Status.ACTIVE
        )

        userRepository.save(registerUser)

        return registerUser
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

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}