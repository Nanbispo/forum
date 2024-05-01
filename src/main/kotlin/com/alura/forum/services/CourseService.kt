package com.alura.forum.services

import com.alura.forum.models.Course
import com.alura.forum.repositories.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val courseRepositoryImpl: CourseRepository) {
    fun serchedId(id: Long): Course{
        return courseRepositoryImpl.getOne(id)
    }
}
