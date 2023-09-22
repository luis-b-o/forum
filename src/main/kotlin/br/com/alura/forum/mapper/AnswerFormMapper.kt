package br.com.alura.forum.mapper

import br.com.alura.forum.dto.NewAnswerForm
import br.com.alura.forum.model.Answer
import br.com.alura.forum.service.TopicService
import br.com.alura.forum.service.UserService
import org.springframework.stereotype.Component

// refactor to use repositories
@Component
class AnswerFormMapper(
    private val userService: UserService,
    private val topicService: TopicService,
) : Mapper<NewAnswerForm, Answer> {
    override fun map(t: NewAnswerForm): Answer {
        return Answer(
            message = t.message,
            author = userService.getById(t.authorId),
            topic = topicService.getById(t.topicId)
        )
    }
}
