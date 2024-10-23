package store.com.domain.user.service

import store.com.application.core.encrypt.PasswordEncrypt
import store.com.application.user.port.UserRepository
import store.com.domain.user.model.User

class LoginService(private val _userRepository: UserRepository, private val _passwordEncrypt: PasswordEncrypt) {
    suspend fun doLoginWithEmail(email: String, password: String): User {
        val userByEmail = this._userRepository.findUserByEmail(email) ?: throw Exception("User not found.")

        if (!_passwordEncrypt.checkPassword(userByEmail.password.orEmpty(), password)) {
            throw Exception("User or password incorrect.")
        }

        return userByEmail
    }
}