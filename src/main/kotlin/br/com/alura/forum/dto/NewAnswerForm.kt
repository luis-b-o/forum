package br.com.alura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NewAnswerForm(

    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val message: String,

    @field:NotNull
    val authorId: Long

)
