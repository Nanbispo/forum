package com.alura.forum.controllers

import com.alura.forum.dtos.TopicForm
import com.alura.forum.dtos.TopicView
import com.alura.forum.dtos.toUpdateTopicForm
import com.alura.forum.services.TopicsServices
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicController(private val service: TopicsServices) {
    @GetMapping
    fun list(): List<TopicView>{
        return service.list()
    }

    @GetMapping("/{id}")
    fun searchID (@PathVariable id: Long): TopicView{
        return service.searchId(id)
    }

    @PostMapping
    fun register (@RequestBody @Valid form: TopicForm){
        service.register(form)
    }

    @PutMapping
    fun toUpdate(@RequestBody @Valid form: toUpdateTopicForm){
        service.toUpdate(form)

    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        service.delete(id)
    }
}