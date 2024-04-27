package com.alura.forum.dtos

import java.time.LocalDateTime

data class ErrorView (
    val timesTamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
)
