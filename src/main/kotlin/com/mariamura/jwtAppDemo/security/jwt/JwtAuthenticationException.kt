package com.mariamura.jwtAppDemo.security.jwt

import org.springframework.security.core.AuthenticationException

class JwtAuthenticationException : AuthenticationException {
    constructor(msg: String?, t: Throwable?) : super(msg, t)
    constructor(msg: String?) : super(msg)
}