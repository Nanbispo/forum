package com.alura.forum.services

import com.alura.forum.models.Users
import com.alura.forum.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService (private val userRepositoryImpl: UserRepository) {
    fun serchedId(id: Long): Users {
        return userRepositoryImpl.getOne(id)
    }
}