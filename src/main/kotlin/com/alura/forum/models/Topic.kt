package com.alura.forum.models

import org.springframework.boot.autoconfigure.security.SecurityProperties
import java.time.LocalDateTime

data class Topic (
    val id: Long? = null,
    val title: String,
    val message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,
    val answers: List<Answers> = ArrayList()
)