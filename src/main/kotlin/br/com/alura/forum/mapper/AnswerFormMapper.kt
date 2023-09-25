package br.com.alura.forum.mapper

import br.com.alura.forum.dto.NewAnswerForm
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.model.Answer
import br.com.alura.forum.repository.TopicRepository
import br.com.alura.forum.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class AnswerFormMapper(
    private val userRepository: UserRepository,
    private val topicRepository: TopicRepository,
) : Mapper<NewAnswerForm, Answer> {
    override fun map(t: NewAnswerForm): Answer {
        return Answer(
            message = t.message,
            author = userRepository.findById(t.authorId).orElseThrow { NotFoundException("User not found") },
            topic = topicRepository.findById(t.topicId).orElseThrow { NotFoundException("Topic not found") }
        )
    }
}
