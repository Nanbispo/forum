package com.alura.forum.repositories

import com.alura.forum.models.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<Topic, Long> {
}