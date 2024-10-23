package store.com.adapter.`in`.http.controller.auth.dto

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn
import store.com.adapter.`in`.http.controller.user.dto.UserDtoMapper
import store.com.application.core.BaseDtoMapper
import store.com.domain.user.model.User

class LoginDtoMapper(private val userDtoMapper: UserDtoMapper) :
    BaseDtoMapper<LoginInputDTO, LoginOutputDto, User>() {
    override fun toDto(output: User): LoginOutputDto {
        val userOutput = userDtoMapper.toDto(output)
        return LoginOutputDto(userOutput, "")
    }

    override fun fromDto(input: LoginInputDTO): User {
        return User(
            name = input.email,
            password = input.password,
            email = "",
            id = 0,
            birthDate = Clock.System.todayIn(TimeZone.currentSystemDefault())
        )
    }
}