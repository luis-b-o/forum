package br.com.alura.forum.service

import br.com.alura.forum.dto.AnswerView
import br.com.alura.forum.dto.NewAnswerForm
import br.com.alura.forum.dto.UpdateAnswerForm
import br.com.alura.forum.mapper.AnswerFormMapper
import br.com.alura.forum.mapper.AnswerViewMapper
import br.com.alura.forum.model.Answer
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AnswerService(
    private var answers: List<Answer>,
    private val answerFormMapper: AnswerFormMapper,
    private val topicService: TopicService,
) {

    fun list(topicId: Long): List<Answer> {
        return answers
            .stream()
            .filter { a -> a.topic?.id == topicId }
            .collect(Collectors.toList())
    }

    fun register(form: NewAnswerForm, topicId: Long): AnswerView {
        val answer = answerFormMapper.map(form)
        answer.id = answers.size.toLong() + 1
        answer.topic = topicService.getById(topicId)
        answers = answers.plus(answer)

        return AnswerViewMapper().map(answer)
    }

    fun update(answer: UpdateAnswerForm): AnswerView {

        val answerToUpdate = answers.stream().findFirst().get()

        val updatedAnswer = Answer(
            id = answerToUpdate.id,
            message = answer.message,
            author = answerToUpdate.author,
            topic = answerToUpdate.topic,
            solution = answerToUpdate.solution
        )

        answers = answers.minus(answerToUpdate).plus(updatedAnswer)

        return AnswerViewMapper().map(updatedAnswer)

    }

    fun delete(id: Long) {

        val answerToDelete = answers.stream().findFirst().get()

        answers = answers.minus(answerToDelete)

    }

}
