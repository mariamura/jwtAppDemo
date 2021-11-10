package com.mariamura.jwtAppDemo.repository

import com.mariamura.jwtAppDemo.model.File
import org.springframework.data.jpa.repository.JpaRepository

interface FileRepository : JpaRepository<File, Long> {
}