package com.mariamura.jwtAppDemo.rest

import com.mariamura.jwtAppDemo.dto.UserDto
import com.mariamura.jwtAppDemo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(value = ["/api/v1/users/"])
class UserRestControllerV1 @Autowired constructor(
    private val userService: UserService,
    private val userDto: UserDto
    )
{
    @GetMapping(value = ["{id}"])
    fun getUserById(@PathVariable(name = "id") id: Long?): ResponseEntity<UserDto> {
        val user = userService.findById(id!!) ?: return ResponseEntity<UserDto>(HttpStatus.NO_CONTENT)
        val result: UserDto = userDto.toDto(user)
        return ResponseEntity<UserDto>(result, HttpStatus.OK)
    }
}