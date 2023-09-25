package br.com.alura.forum.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Answer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val author: User,
    @ManyToOne
    var topic: Topic,
    val solution: Boolean = false
)
