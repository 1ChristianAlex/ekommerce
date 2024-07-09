package store.com.domain.user.service

import store.com.application.user.port.UserRepository
import store.com.domain.user.model.UserModel

class LoginService(private val _userRepository: UserRepository) {
    suspend fun doLoginWithEmail(email: String, password: String): UserModel {
        return this._userRepository.getUserByEmailPassword(email, password)
    }
}