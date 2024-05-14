package com.alura.forum.services

import com.alura.forum.models.User
import com.alura.forum.repositories.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*

@Service
class UserService(private val userRepositoryImpl: UserRepository) : UserDetailsService {
    fun serchedId(id: Long): User {
        return userRepositoryImpl.getOne(id)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepositoryImpl.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(user)
    }
}