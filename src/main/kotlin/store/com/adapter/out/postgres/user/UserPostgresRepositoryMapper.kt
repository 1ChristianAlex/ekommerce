package store.com.adapter.out.postgres.user

import kotlinx.datetime.toJavaLocalDate
import kotlinx.datetime.toKotlinLocalDate
import store.com.adapter.out.postgres.model.UserEntity
import store.com.application.user.port.UserRepositoryMapper
import store.com.domain.user.model.UserModel

class UserPostgresRepositoryMapper : UserRepositoryMapper<UserEntity> {
    override fun toModel(input: UserEntity): UserModel {
        return input.let {
            UserModel(email = it.email, birthDate = it.birthDate.toKotlinLocalDate(), id = it.id, name = it.name)
        }
    }

    override fun fromModel(output: UserModel): UserEntity {
        return output.let {
            UserEntity(
                email = it.email,
                birthDate = it.birthDate.toJavaLocalDate(),
                id = it.id,
                name = it.name,
                password = ""
            )
        }
    }
}