package br.com.alura.forum.service

import br.com.alura.forum.model.User
import org.springframework.stereotype.Service

@Service
class UserService(
    var users: List<User>
) {

    init {
        val user = User(
            id = 1,
            name = "John",
            email = "john.doe@gmail.com"
        )
        users = listOf(user)
        
    }

    fun getById(id: Long): User {
        return users.stream().filter { u -> u.id == id }.findFirst().get()
    }
}
