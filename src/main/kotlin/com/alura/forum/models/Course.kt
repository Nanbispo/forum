package com.alura.forum.models

import jakarta.persistence.*


@Entity
@Table(name = "course")
data class Course (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val category: String
)
