package br.com.alura.forum.model

import java.time.LocalDateTime

class Topic {
    val id: Long? = null
    val title: String = ""
    val message: String = ""
    val creationDate: LocalDateTime = LocalDateTime.now()
    val course: Course = Course()
    val author: User = User()
    val status: TopicStatus = TopicStatus.NOT_ANSWERED
    val answers: List<Answer> = ArrayList()
}