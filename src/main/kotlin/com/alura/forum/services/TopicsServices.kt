package com.alura.forum.services

import com.alura.forum.dtos.TopicForm
import com.alura.forum.dtos.TopicView
import com.alura.forum.dtos.toUpdateTopicForm
import com.alura.forum.mappers.TopicFormMapper
import com.alura.forum.mappers.TopicViewMapper
import com.alura.forum.models.Topic
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicsServices(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapeer: TopicFormMapper
) {

    fun list(): List<TopicView> {
        return topics.stream().map {
            t -> topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun searchId(id: Long): TopicView {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return topicViewMapper.map(topic)
    }

    fun register(form: TopicForm) {
        val topic = topicFormMapeer.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }

    fun toUpdate(form: toUpdateTopicForm) {
        val topic = topics.stream().filter { t ->
            t.id == form.id
        }.findFirst().get()
        topics = topics.minus(topic).plus(
            Topic(
                id = form.id,
                title = form.title,
                message = form.message,
                author = topic.author,
                course = topic.course,
                creationDate = topic.creationDate,
                status = topic.status,
                answers = topic.answers
            )
        )
    }

    fun delete(id: Long) {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        topics = topics.minus(topic)
    }
}