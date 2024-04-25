package com.alura.forum.mappers

import com.alura.forum.dtos.TopicView
import com.alura.forum.models.Topic

interface Mapper<T, U> {
     fun map(t: T): U
}
