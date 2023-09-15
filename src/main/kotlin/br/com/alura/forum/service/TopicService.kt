package br.com.alura.forum.service

import br.com.alura.forum.model.Course
import br.com.alura.forum.model.Topic
import br.com.alura.forum.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicService {
    fun list(): List<Topic> {
        val topic: Topic = Topic(
            id = 1,
            title = "Kotlin Question",
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

        return Arrays.asList(topic, topic, topic)
    }

}