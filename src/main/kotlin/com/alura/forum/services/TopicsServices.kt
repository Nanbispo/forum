package com.alura.forum.services

import com.alura.forum.models.Course
import com.alura.forum.models.Topic
import com.alura.forum.models.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicsServices(private var topics: List<Topic>) {

    init {
        val topic = Topic(
            id = 1,
            title = "Variveis em kotlin",
            message = "Oque são variaveis",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programação"
            ),
            author = User(
                id = 1,
                name = "Renan",
                email = "renan@gmail.com"
            )
        )
        val topic2 = Topic(
            id = 2,
            title = "Funções em kotlin",
            message = "Oque são Funções",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programação"
            ),
            author = User(
                id = 1,
                name = "Renan",
                email = "renan@gmail.com"
            )
        )

        val topic3 = Topic(
            id = 3,
            title = "Tipos de dados em kotlin",
            message = "Quais são os tipos de dados",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programação"
            ),
            author = User(
                id = 1,
                name = "Renan",
                email = "renan@gmail.com"
            )
        )
        topics = Arrays.asList(topic, topic2, topic3)
    }
    fun list(): List<Topic> {
        return topics
    }

    fun searchId(id: Long): Topic {
        return topics.stream().filter({
            t -> t.id == id
        }).findFirst().get()
    }
}