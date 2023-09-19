package br.com.alura.forum.service

import br.com.alura.forum.dto.NewTopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.UpdateTopicForm
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
) {


    fun list(): List<TopicView> {
        return topics.stream().map { t ->
            topicViewMapper.map(t)
        }.toList()
    }

    fun getById(id: Long): TopicView {
        val topic = topics.stream().filter { t -> t.id == id }.findFirst().get()
        return TopicViewMapper().map(topic)
    }

    fun register(form: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(topic: UpdateTopicForm): TopicView {
        val topicToUpdate = topics
            .stream()
            .filter { t -> t.id == topic.id }
            .findFirst().get()

        val updatedTopic = Topic(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            course = topicToUpdate.course,
            author = topicToUpdate.author,
            status = topicToUpdate.status,
            answers = topicToUpdate.answers,
            creationDate = topicToUpdate.creationDate
        )

        topics = topics.minus(topicToUpdate).plus(
            updatedTopic
        )

        return topicViewMapper.map(updatedTopic)
    }

    fun delete(id: Long) {
        val topicToDelete = topics.stream().filter { t -> t.id == id }.findFirst().get()
        topics = topics.minus(topicToDelete)
    }

}