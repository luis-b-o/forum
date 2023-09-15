package br.com.alura.forum.service

import br.com.alura.forum.model.Answer
import br.com.alura.forum.model.Course
import br.com.alura.forum.model.Topic
import br.com.alura.forum.model.User
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AnswerService(private var answers: List<Answer>) {

    init {
        val course: Course = Course(
            id = 1,
            name = "Kotlin",
            category = "Programming"
        )

        val author: User = User(
            id = 1,
            name = "John",
            email = "john.doe@gmail.com"
        )

        val topic: Topic = Topic(
            id = 1,
            title = "Kotlin Question 1",
            message = "Variables",
            course = course,
            author = author,
            answers = answers,
        )

        val answer1: Answer = Answer(
            id = 1,
            message = "Variables",
            author = author,
            topic = topic,
        )

        val answer2: Answer = Answer(
            id = 2,
            message = "Variables",
            author = author,
            topic = topic,
        )

        val answer3: Answer = Answer(
            id = 3,
            message = "Variables",
            author = author,
            topic = topic,
        )

        answers = listOf(answer1, answer2, answer3)
    }

    fun list(topicId: Long): List<Answer> {
        return answers
            .stream()
            .filter { a -> a.topic.id == topicId }
            .collect(Collectors.toList())
    }

}
