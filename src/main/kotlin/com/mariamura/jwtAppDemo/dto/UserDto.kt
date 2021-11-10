package com.mariamura.jwtAppDemo.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.mariamura.jwtAppDemo.model.User
import org.springframework.stereotype.Component

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
data class UserDto(
    private val id: Long? = null,
    private val username: String? = null
) {
    fun toDto(user: User) = UserDto(
        id = user.id,
        username = user.username
    )

    fun fromUser() = UserDto(
        id = id,
        username = username
    )
}