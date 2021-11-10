package com.mariamura.jwtAppDemo.repository

import com.mariamura.jwtAppDemo.model.Event
import org.springframework.data.jpa.repository.JpaRepository

interface Event: JpaRepository<Event, Long> {
}