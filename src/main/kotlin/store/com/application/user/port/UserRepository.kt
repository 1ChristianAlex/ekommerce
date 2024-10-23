package store.com.application.user.port

import store.com.domain.user.model.User

interface UserRepository {
    suspend fun createUser(newUser: User): User
    suspend fun findUserByEmail(email: String): User?
}