package store.com.domain.user.service

import store.com.application.user.port.UserRepository
import store.com.domain.user.model.User

class UserService(private val userRepository: UserRepository) {

    suspend fun createNewUser(newUser: User): User {

        return userRepository.createUser(newUser)
    }
}