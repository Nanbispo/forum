package com.alura.forum.dtos

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.NotBlank

data class TopicForm (
   @field:NotEmpty val title: String,
   @field:NotEmpty @field:Size(min = 5, max = 100) val message: String,
   @field:NotNull val idCourse: Long,
   @field:NotNull val idAuthor: Long
)
