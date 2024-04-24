package com.alura.forum.controllers

import com.alura.forum.models.Course
import com.alura.forum.models.Topic
import com.alura.forum.models.User
import com.alura.forum.services.TopicsServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicController(private val service: TopicsServices) {
    @GetMapping
    fun list(): List<Topic>{
        return service.list()
    }

    @GetMapping("/{id}")
    fun searchID (@PathVariable id: Long): Topic{
        return service.searchId(id)
    }
}