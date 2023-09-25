package br.com.alura.forum.service

import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.model.Course
import br.com.alura.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
    private val repository: CourseRepository,
    private val notFoundMessage: String = "Course not found"
) {

    fun getById(id: Long): Course {
        return repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
    }

}
