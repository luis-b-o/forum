package br.com.alura.forum.mapper

import br.com.alura.forum.dto.AnswerView
import br.com.alura.forum.model.Answer
import org.springframework.stereotype.Component

@Component
class AnswerViewMapper : Mapper<Answer, AnswerView> {

    override fun map(a: Answer): AnswerView {
        return AnswerView(
            id = a.id as Long,
            message = a.message,
        )
    }
}
