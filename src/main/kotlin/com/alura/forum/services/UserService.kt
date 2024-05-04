package com.alura.forum.services

import com.alura.forum.models.User
import com.alura.forum.repositories.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService (private val userRepositoryImpl: UserRepository) {
    fun serchedId(id: Long): User {
        return userRepositoryImpl.getOne(id)
    }
}