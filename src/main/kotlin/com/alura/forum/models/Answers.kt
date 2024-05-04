package com.alura.forum.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "answers")
data class Answers (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val author: User,
    @ManyToOne
    val topic: Topic,
    val solution: Boolean
)
