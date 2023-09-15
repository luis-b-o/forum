package br.com.alura.forum.service

import br.com.alura.forum.model.Course
import br.com.alura.forum.model.Topic
import br.com.alura.forum.model.User
import org.springframework.stereotype.Service

@Service
class TopicService(private var topics: List<Topic>) {

    init {
        val topic1: Topic = Topic(
            id = 1,
            title = "Kotlin Question 1",
            message = "Variables",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programming"
            ),
            author = User(
                id = 1,
                name = "John",
                email = "john.doe@email.com"
            ),
        )
        val topic2: Topic = Topic(
            id = 2,
            title = "Kotlin Question 2",
            message = "Variables",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programming"
            ),
            author = User(
                id = 1,
                name = "John",
                email = "john.doe@email.com"
            ),
        )
        val topic3: Topic = Topic(
            id = 3,
            title = "Kotlin Question 3",
            message = "Variables",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programming"
            ),
            author = User(
                id = 1,
                name = "John",
                email = "john.doe@email.com"
            ),
        )

        topics = listOf(topic1, topic2, topic3)
    }

    fun list(): List<Topic> {
        return topics
    }

    fun getById(id: Long): Topic {
        return topics.stream().filter { t -> t.id == id }.findFirst().get()
    }

}