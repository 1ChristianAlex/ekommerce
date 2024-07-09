package store.com.application.user.port

import store.com.domain.user.model.UserModel

interface UserRepository {
    suspend fun getUserByEmailPassword(email: String, password: String): UserModel
}