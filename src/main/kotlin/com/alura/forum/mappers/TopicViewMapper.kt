package com.alura.forum.mappers

import com.alura.forum.dtos.TopicView
import com.alura.forum.models.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicView> {

    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.status,
            creationDate = t.creationDate
        )
    }
}