package com.mariamura.jwtAppDemo.service.impl

import com.mariamura.jwtAppDemo.model.Role
import com.mariamura.jwtAppDemo.model.Status
import com.mariamura.jwtAppDemo.model.User
import com.mariamura.jwtAppDemo.repository.UserRepository
import com.mariamura.jwtAppDemo.repository.impl.RoleRepository
import com.mariamura.jwtAppDemo.service.UserService
import org.slf4j.Logger
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service


@Service
@Slf4j
class UserServiceImpl @Autowired constructor(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder
    ) : UserService {

    override fun register(user: User): User {
        val roleUser = roleRepository.findByName("ROLE_USER")
        val userRoles: List<Role> = listOf(roleUser)

        val registerUser =  user.copy(
            password = bCryptPasswordEncoder.encode(user.password),
            roles = user.roles,
            status = Status.ACTIVE
        )

        val registeredUser = userRepository.save(user)

        return registerUser
        //log.info("IN register - user: {} successfully registered", registeredUser)
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