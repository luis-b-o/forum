package br.com.alura.forum.service

import br.com.alura.forum.dto.AnswerView
import br.com.alura.forum.dto.NewAnswerForm
import br.com.alura.forum.dto.UpdateAnswerForm
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.AnswerFormMapper
import br.com.alura.forum.mapper.AnswerViewMapper
import br.com.alura.forum.repository.AnswerRepository
import org.springframework.stereotype.Service

@Service
class AnswerService(
    private val answerRepository: AnswerRepository,
    private val answerFormMapper: AnswerFormMapper,
    private val notFoundMessage: String = "Topic not found"
) {

    fun list(topicId: Long): List<AnswerView> {
        val answers = answerRepository.findAllByTopicId(topicId)

        return answers.stream().map { t ->
            AnswerViewMapper().map(t)
        }.toList()
    }

    fun register(form: NewAnswerForm): AnswerView {
        val answer = answerRepository.save(answerFormMapper.map(form))

        return AnswerViewMapper().map(answer)
    }

    fun update(form: UpdateAnswerForm): AnswerView {

        val answer = answerRepository.findById(form.answerId)
            .orElseThrow { NotFoundException(notFoundMessage) }

        answer.message = form.message

        answerRepository.save(answer)

        return AnswerViewMapper().map(answer)

    }

    fun delete(id: Long) {

        answerRepository.deleteById(id)

    }

}
