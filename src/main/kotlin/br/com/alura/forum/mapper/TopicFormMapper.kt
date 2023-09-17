package br.com.alura.forum.mapper

import br.com.alura.forum.dto.NewTopicForm
import br.com.alura.forum.model.Topic
import br.com.alura.forum.service.CourseService
import br.com.alura.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private var courseService: CourseService,
    private var userService: UserService,
) : Mapper<NewTopicForm, Topic> {

    override fun map(tf: NewTopicForm): Topic {
        return Topic(
            title = tf.title,
            message = tf.message,
            course = courseService.getById(tf.courseId),
            author = userService.getById(tf.authorId),
        )
    }
}

