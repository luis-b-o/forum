package br.com.alura.forum.controller

import br.com.alura.forum.dto.NewAnswerForm
import br.com.alura.forum.model.Answer
import br.com.alura.forum.service.AnswerService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topics/{topicId}/answers")
class AnswerController(private val service: AnswerService) {

    @GetMapping
    fun list(@PathVariable topicId: Long): List<Answer> {
        return service.list(topicId)
    }

    @PostMapping
    fun register(
        @PathVariable topicId: Long,
        @RequestBody @Valid answer: NewAnswerForm
    ) {
        service.register(answer, topicId)
    }

}