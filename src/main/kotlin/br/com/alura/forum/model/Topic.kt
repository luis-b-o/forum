package br.com.alura.forum.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Topic(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var title: String,
    var message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val course: Course,
    @ManyToOne
    val author: User,
    @Enumerated(value = EnumType.STRING)
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,
    @OneToMany(mappedBy = "topic")
    val answers: List<Answer> = ArrayList()
)