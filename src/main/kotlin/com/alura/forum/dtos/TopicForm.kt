package com.alura.forum.dtos

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.NotBlank


data class TopicForm (
   @field:NotEmpty(message = "Titulo está em branco")
   @field:Size(min = 5, max = 100, message = "O texto deve ter entre 5 e 100 caracteres")
   @field:NotNull
   val title: String,
   @field:NotEmpty
   val message: String,
   @field:NotNull
   val idCourse: Long,
   @field:NotNull
   val idAuthor: Long
)
