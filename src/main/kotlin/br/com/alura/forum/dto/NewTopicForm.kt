package br.com.alura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NewTopicForm(
    @field:NotEmpty
    @field:Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    val title: String,

    @field:NotEmpty(message = "Message cannot be empty")
    val message: String,

    @field:NotNull
    val courseId: Long,

    @field:NotNull
    val authorId: Long
)
