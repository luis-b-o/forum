package br.com.alura.forum.controller

import br.com.alura.forum.dto.AnswerView
import br.com.alura.forum.dto.NewAnswerForm
import br.com.alura.forum.model.Answer
import br.com.alura.forum.service.AnswerService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

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
        @RequestBody @Valid answer: NewAnswerForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<AnswerView> {
        val answerView = service.register(answer, topicId)
        val uri = uriBuilder.path("/topics/${topicId}/${answerView.id}").build().toUri()
        
        return ResponseEntity.created(uri).body(answerView)
    }

}