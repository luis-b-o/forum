package br.com.alura.forum.controller

import br.com.alura.forum.dto.AnswerView
import br.com.alura.forum.dto.NewAnswerForm
import br.com.alura.forum.dto.UpdateAnswerForm
import br.com.alura.forum.service.AnswerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics/{topicId}/answers")
class AnswerController(private val service: AnswerService) {

    @GetMapping
    fun list(@PathVariable topicId: Long): List<AnswerView> {
        return service.list(topicId)
    }

    @PostMapping
    @Transactional
    fun register(
        @PathVariable topicId: Long,
        @RequestBody @Valid answer: NewAnswerForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<AnswerView> {
        answer.topicId = topicId
        val answerView = service.register(answer)
        val uri = uriBuilder.path("/topics/${topicId}/${answerView.id}").build().toUri()

        return ResponseEntity.created(uri).body(answerView)
    }

    @PutMapping
    @Transactional
    fun update(
        @RequestBody @Valid answer: UpdateAnswerForm,
    ): ResponseEntity<AnswerView> {
        val updatedAnswer = service.update(answer)

        return ResponseEntity.ok(updatedAnswer)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }


}