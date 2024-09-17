package store.com.application.user.port

import store.com.domain.user.model.UserModel

interface UserRepository {
    suspend fun createUser(newUser: UserModel): UserModel
    suspend fun findUserByEmail(email: String): UserModel?
}