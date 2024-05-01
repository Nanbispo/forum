package com.alura.forum.controllers

import com.alura.forum.dtos.TopicForm
import com.alura.forum.dtos.TopicView
import com.alura.forum.dtos.toUpdateTopicForm
import com.alura.forum.services.TopicsServices
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder

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
    @Transactional
    fun register (
        @RequestBody @Valid form: TopicForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView>{
        val topicView = service.register(form)
        val uri = uriBuilder.path("/topicos/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    @Transactional
    fun toUpdate(@RequestBody @Valid form: toUpdateTopicForm): ResponseEntity<TopicView>{
        val topicView = service.toUpdate(form)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id: Long){
        service.delete(id)
    }
}