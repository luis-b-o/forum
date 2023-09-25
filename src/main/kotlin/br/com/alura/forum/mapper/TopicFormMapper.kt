package br.com.alura.forum.mapper

import br.com.alura.forum.dto.NewTopicForm
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.model.Topic
import br.com.alura.forum.repository.CourseRepository
import br.com.alura.forum.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private var courseRepository: CourseRepository,
    private var userRepository: UserRepository,
) : Mapper<NewTopicForm, Topic> {

    override fun map(t: NewTopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseRepository.findById(t.courseId).orElseThrow { NotFoundException("Course not found") },
            author = userRepository.findById(t.authorId).orElseThrow { NotFoundException("User not found") },
        )
    }
}

