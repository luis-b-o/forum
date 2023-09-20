package br.com.alura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class UpdateAnswerForm(
    @field:NotEmpty
    val message: String,

    @field:NotNull
    val answerId: Long

)
