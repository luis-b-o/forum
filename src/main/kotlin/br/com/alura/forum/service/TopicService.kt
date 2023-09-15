package br.com.alura.forum.service

import br.com.alura.forum.dto.NewTopicDTO
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private var courseService: CourseService,
    private var userService: UserService
) {

    fun list(): List<Topic> {
        return topics
    }

    fun getById(id: Long): Topic {
        return topics.stream().filter { t -> t.id == id }.findFirst().get()
    }

    fun register(topic: NewTopicDTO) {
        topics = topics.plus(
            Topic(
                id = topics.size.toLong() + 1,
                title = topic.title,
                message = topic.message,
                course = courseService.getById(topic.courseId),
                author = userService.getById(topic.authorId),
            ),
        )
    }

}