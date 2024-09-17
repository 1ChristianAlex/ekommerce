package store.com.domain.user.service

import store.com.application.user.port.UserRepository
import store.com.domain.user.model.UserModel

class UserService(private val userRepository: UserRepository) {

    suspend fun createNewUser(newUser: UserModel): UserModel {
        newUser.id = 0

        return userRepository.createUser(newUser)
    }
}