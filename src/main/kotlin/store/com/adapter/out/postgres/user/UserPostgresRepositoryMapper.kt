package store.com.adapter.out.postgres.user

import store.com.adapter.out.postgres.model.UserEntity
import store.com.application.user.port.UserRepositoryMapper
import store.com.domain.user.model.UserModel

class UserPostgresRepositoryMapper : UserRepositoryMapper<UserEntity> {
    override fun toModel(input: UserEntity): UserModel {
        return input.let {
            UserModel(
                email = it.email,
                birthDate = it.birthDate,
                id = it.id.value,
                name = it.name,
                password = input.password
            )
        }
    }

    override fun fromModel(output: UserModel): UserEntity {
        TODO("Not yet implemented")
    }


}