package com.alura.forum.controllers

import com.alura.forum.dtos.TopicForm
import com.alura.forum.dtos.TopicView
import com.alura.forum.dtos.toUpdateTopicForm
import com.alura.forum.services.TopicsServices
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topicos")
class TopicController(private val service: TopicsServices) {
    @GetMapping
    fun list(@RequestParam(required = false)
             courseName: String?,
             @PageableDefault(size = 5, sort = ["creationDate"])
             pagination: Pageable
    ): Page<TopicView> {
        return service.list(courseName, pagination)
    }

    @GetMapping("/{id}")
    fun searchID (@PathVariable id: Long): TopicView{
        return service.searchId(id)
    }

    @PostMapping
    @Transactional
    fun register (@RequestBody @Valid form: TopicForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicView>{
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