package store.com.adapter.out.memory.user

import kotlinx.datetime.*
import store.com.adapter.out.memory.model.UserEntity
import store.com.application.user.port.UserRepository
import store.com.application.user.port.UserRepositoryMapper
import store.com.domain.user.model.UserModel

class UserMemoryRepository(private val _userMemoryMapper: UserRepositoryMapper<UserEntity>) : UserRepository {
    override suspend fun getUserByEmailPassword(email: String, password: String): UserModel {
        val result = UserEntity(
            id = 1,
            email = "christian.alexsander@outlook.com",
            birthDate = LocalDateTime(
                LocalDate(1999, 6, 13),
                Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).time
            ),
            password = "123456",
            name = "Christian Alexsander"
        )

        return _userMemoryMapper.toModel(result)
    }
}