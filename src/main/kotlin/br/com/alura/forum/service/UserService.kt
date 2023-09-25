package br.com.alura.forum.service

import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.model.User
import br.com.alura.forum.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository,
    private val notFoundMessage: String = "User not found"
) {

    fun getById(id: Long): User {
        // create a mapper for it
        return repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
    }
}
