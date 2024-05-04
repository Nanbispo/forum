package com.alura.forum.dtos

import ch.qos.logback.core.status.Status
import com.alura.forum.models.TopicStatus
import java.time.LocalDateTime

data class TopicView (
    val id: Long? = null,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val creationDate: LocalDateTime
)
