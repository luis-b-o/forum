package br.com.alura.forum.model

import br.com.alura.forum.dto.TopicView
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Answer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val author: User,
    @ManyToOne
    var topic: TopicView,
    val solution: Boolean = false
)
