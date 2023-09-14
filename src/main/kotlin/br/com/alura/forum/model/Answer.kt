package br.com.alura.forum.model

import java.time.LocalDateTime

data class Answer(
    val id: Long? = null,
    val message: String = "",
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val solution: Boolean = false
)
