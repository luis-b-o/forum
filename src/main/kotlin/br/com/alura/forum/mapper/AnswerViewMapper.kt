package br.com.alura.forum.mapper

import br.com.alura.forum.dto.AnswerView
import br.com.alura.forum.model.Answer
import org.springframework.stereotype.Component

@Component
class AnswerViewMapper : Mapper<Answer, AnswerView> {

    override fun map(t: Answer): AnswerView {
        return AnswerView(
            id = t.id as Long,
            message = t.message,
        )
    }
}
