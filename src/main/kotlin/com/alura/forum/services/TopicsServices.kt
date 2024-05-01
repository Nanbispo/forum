package com.alura.forum.services

import com.alura.forum.dtos.TopicForm
import com.alura.forum.dtos.TopicView
import com.alura.forum.dtos.toUpdateTopicForm
import com.alura.forum.exceptions.NotFoundException
import com.alura.forum.mappers.TopicFormMapper
import com.alura.forum.mappers.TopicViewMapper
import com.alura.forum.repositories.TopicRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicsServices(
    private val topicRepositoryImpl: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapeer: TopicFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado"
) {

    fun list(): List<TopicView> {
        return topicRepositoryImpl.findAll().stream().map {
            t -> topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun searchId(id: Long): TopicView {
        val topic = topicRepositoryImpl.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        return topicViewMapper.map(topic)
    }

    fun register(form: TopicForm): TopicView {
        val topic = topicFormMapeer.map(form)
        topicRepositoryImpl.save(topic)
        return topicViewMapper.map(topic)
    }

    fun toUpdate(form: toUpdateTopicForm): TopicView {
        val topic = topicRepositoryImpl.findById(form.id)
            .orElseThrow{NotFoundException(notFoundMessage)}

        topic.title = form.title
        topic.message = form.message
        return topicViewMapper.map(topic)
    }

    fun delete(id: Long) {
        topicRepositoryImpl.deleteById(id)
    }
}