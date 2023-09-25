package br.com.alura.forum.service

import br.com.alura.forum.dto.NewTopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.UpdateTopicForm
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.repository.TopicRepository
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val repository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topic not found"
) {


    fun list(): List<TopicView> {
        val topics = repository.findAll()

        return topics.stream().map { t ->
            topicViewMapper.map(t)
        }.toList()
    }

    fun getById(id: Long): TopicView {
        val topic = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }

        return TopicViewMapper().map(topic)
    }

    fun register(form: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        repository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun update(form: UpdateTopicForm): TopicView {
        val topic = repository.findById(form.id)
            .orElseThrow { NotFoundException(notFoundMessage) }

        topic.title = form.title
        topic.message = form.message

        repository.save(topic)

        return topicViewMapper.map(topic)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

}