package com.mariamura.jwtAppDemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JwtAppDemoApplication

fun main(args: Array<String>) {
	runApplication<JwtAppDemoApplication>(*args)
}
