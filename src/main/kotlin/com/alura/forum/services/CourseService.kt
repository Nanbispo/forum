package com.alura.forum.services

import com.alura.forum.models.Course
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(var courses: List<Course>) {

    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "Programação"
        )
        courses = Arrays.asList(course)
    }

    fun serchedId(id: Long): Course{
        return courses.stream().filter({
            c -> c.id == id
        }).findFirst().get()
    }
}
