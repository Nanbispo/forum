package com.alura.forum.services

import com.alura.forum.models.Course
import com.alura.forum.models.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService (var users: List<User>) {

    init {
        val user = User(
            id = 1,
            name = "Renan",
            email = "renan@email.com"
        )
        users = Arrays.asList(user)
    }

    fun serchedId(id: Long): User {
        return users.stream().filter({ u ->
            u.id == id
        }).findFirst().get()
    }
}