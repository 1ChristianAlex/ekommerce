package store.com.domain.user.service

import store.com.application.user.port.LoginRepository
import store.com.domain.user.model.UserModel

class LoginService(private val _userRepository: LoginRepository) {
    suspend fun doLoginWithEmail(email: String, password: String): UserModel {
        return this._userRepository.getUserByEmailPassword(email, password)
    }
}