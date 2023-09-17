package br.com.alura.forum.model

import br.com.alura.forum.dto.TopicView
import java.time.LocalDateTime

data class Answer(
    var id: Long? = null,
    val message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val author: User,
    var topic: TopicView? = null,
    val solution: Boolean = false
)
