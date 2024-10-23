package store.com.adapter.out.postgres.user

import store.com.adapter.out.postgres.model.UserEntity
import store.com.application.user.port.UserRepositoryMapper
import store.com.domain.user.model.User

class UserPostgresRepositoryMapper : UserRepositoryMapper<UserEntity> {
    override fun toModel(input: UserEntity): User {
        return input.let {
            User(
                email = it.email,
                birthDate = it.birthDate,
                id = it.id.value,
                name = it.name,
                password = input.password
            )
        }
    }

    override fun fromModel(output: User): UserEntity {
        TODO("Not yet implemented")
    }


}