package com.alura.forum.repositories

import com.alura.forum.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
}