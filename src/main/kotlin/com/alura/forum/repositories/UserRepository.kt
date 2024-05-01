package com.alura.forum.repositories

import com.alura.forum.models.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<Users, Long> {
}