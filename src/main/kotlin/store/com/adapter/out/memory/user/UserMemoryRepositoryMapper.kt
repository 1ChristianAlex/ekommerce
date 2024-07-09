package store.com.adapter.out.memory.user

import store.com.adapter.out.memory.model.UserEntity
import store.com.application.user.port.UserRepositoryMapper
import store.com.domain.user.model.UserModel

class UserMemoryRepositoryMapper : UserRepositoryMapper<UserEntity> {
    override fun toModel(input: UserEntity): UserModel {
        return UserModel(email = input.email, birthDate = input.birthDate, id = input.id, name = input.name)
    }

    override fun fromModel(output: UserModel): UserEntity {
        return UserEntity(
            email = output.email,
            birthDate = output.birthDate,
            id = output.id,
            name = output.name,
            password = null
        )
    }
}