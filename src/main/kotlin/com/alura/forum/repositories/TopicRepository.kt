package com.alura.forum.repositories

import com.alura.forum.dtos.TopicByCategoryDto
import com.alura.forum.models.Topic

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository: JpaRepository<Topic, Long> {
    fun findByCourseName(courseName: String, pagination: Pageable): Page<Topic>

    @Query("SELECT new com.alura.forum.dtos.TopicByCategoryDto(course.category, count(t)) FROM Topic t JOIN t.course course GROUP BY course.category")
    fun  report(): List<TopicByCategoryDto>
}