package br.com.alura.forum.service

import br.com.alura.forum.dto.NewTopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private var courseService: CourseService,
    private var userService: UserService
) {

    fun list(): List<TopicView> {
        return topics.stream().map { t ->
            TopicView(
                id = t.id as Long,
                title = t.title,
                message = t.message,
                status = t.status,
                creationDate = t.creationDate,
            )
        }.toList()
    }

    fun getById(id: Long): TopicView {
        val topic = topics.stream().filter { t -> t.id == id }.findFirst().get()
        return TopicView(
            id = topic.id as Long,
            title = topic.title,
            message = topic.message,
            status = topic.status,
            creationDate = topic.creationDate,
        )
    }

    fun register(topic: NewTopicForm) {
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