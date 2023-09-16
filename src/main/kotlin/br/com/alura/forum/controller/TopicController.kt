package br.com.alura.forum.controller

import br.com.alura.forum.dto.NewTopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.service.TopicService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun list(): List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TopicView {
        return service.getById(id)
    }

    @PostMapping
    fun register(@RequestBody topic: NewTopicForm) {
        service.register(topic)
    }

}