package store.com.adapter.out.postgres.user


import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import store.com.adapter.out.postgres.model.UserEntity
import store.com.adapter.out.postgres.model.UserTable
import store.com.application.user.port.UserRepository
import store.com.application.user.port.UserRepositoryMapper
import store.com.domain.user.model.User

class UserPostgresRepository(
    private val userRepositoryMapper: UserRepositoryMapper<UserEntity>
) : UserRepository {
    override suspend fun createUser(newUser: User): User = transaction {
        val userEntity = UserEntity.new {
            email = newUser.email
            name = newUser.name
            birthDate = newUser.birthDate
            password = newUser.password ?: throw Error("Password is required")
        }

        userRepositoryMapper.toModel(userEntity)
    }

    override suspend fun findUserByEmail(email: String): User? {
        return newSuspendedTransaction {
            val user = UserEntity.find { UserTable.email eq email }

            if (!user.empty()) {
                return@newSuspendedTransaction userRepositoryMapper.toModel(user.first())
            }

            return@newSuspendedTransaction null
        }
    }
}