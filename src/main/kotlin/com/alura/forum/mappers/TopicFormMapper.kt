package com.alura.forum.mappers

import com.alura.forum.dtos.TopicForm
import com.alura.forum.models.Topic
import com.alura.forum.services.CourseService
import com.alura.forum.services.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService): Mapper<TopicForm, Topic> {
    override fun map(t: TopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.serchedId(t.idCourse),
            author = userService.serchedId(t.idAuthor)
        )
    }

}
