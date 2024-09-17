package store.com.adapter.out.postgres.user

import org.ktorm.dsl.eq
import org.ktorm.dsl.insertAndGenerateKey
import org.ktorm.entity.find
import org.ktorm.entity.sequenceOf
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

    private val getUserTable get() = _database.database.sequenceOf(UserTable)

    override suspend fun createUser(newUser: UserModel): UserModel {
        val userEntity = userRepositoryMapper.fromModel(newUser)

        _database.database.insertAndGenerateKey(UserTable) {
            it.entityToTable(this, userEntity)
        }

        return userRepositoryMapper.toModel(userEntity)
    }

    override suspend fun findUserByEmail(email: String): UserModel? {
        val user = getUserTable.find {
            it.email.eq(email)
        }

        if (user != null) {
            return userRepositoryMapper.toModel(user)
        }

        return null
    }
}