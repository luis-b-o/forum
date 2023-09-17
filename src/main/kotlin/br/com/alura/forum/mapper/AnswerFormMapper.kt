package br.com.alura.forum.mapper

import br.com.alura.forum.dto.NewAnswerForm
import br.com.alura.forum.model.Answer
import br.com.alura.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class AnswerFormMapper(
    private val userService: UserService,
) : Mapper<NewAnswerForm, Answer> {
    override fun map(a: NewAnswerForm): Answer {
        return Answer(
            message = a.message,
            author = userService.getById(a.authorId),
        )
    }
}
