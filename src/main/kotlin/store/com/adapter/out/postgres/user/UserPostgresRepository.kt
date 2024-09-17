package store.com.adapter.out.postgres.user


import store.com.adapter.out.postgres.model.UserEntity
import store.com.adapter.out.postgres.model.UserTable
import store.com.application.core.BaseDatabase
import store.com.application.user.port.UserRepository
import store.com.application.user.port.UserRepositoryMapper
import store.com.domain.user.model.UserModel

class UserPostgresRepository(
    private val _database: BaseDatabase,
    private val userRepositoryMapper: UserRepositoryMapper<UserEntity>
) : UserRepository {


    override suspend fun createUser(newUser: UserModel): UserModel {
        val userEntity = UserEntity.new {
            email = newUser.email
            name = newUser.name
            birthDate = newUser.birthDate
            password = "123456789"
        }

        return userRepositoryMapper.toModel(userEntity)
    }

    override suspend fun findUserByEmail(email: String): UserModel? {
        val user = UserEntity.find { UserTable.email eq email }

        if (!user.empty()) {
            return userRepositoryMapper.toModel(user.first())
        }

        return null
    }
}