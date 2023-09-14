package br.com.alura.forum.controller

import br.com.alura.forum.model.Course
import br.com.alura.forum.model.Topic
import br.com.alura.forum.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topics")
class TopicController {

    @GetMapping
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