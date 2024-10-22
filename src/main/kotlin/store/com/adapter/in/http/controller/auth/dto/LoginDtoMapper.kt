package store.com.adapter.`in`.http.controller.auth.dto

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayAt
import store.com.adapter.`in`.http.controller.user.dto.UserDtoMapper
import store.com.application.core.BaseDtoMapper
import store.com.domain.user.model.UserModel

class LoginDtoMapper(private val userDtoMapper: UserDtoMapper) :
    BaseDtoMapper<LoginInputDTO, LoginOutputDto, UserModel>() {
    override fun toDto(output: UserModel): LoginOutputDto {
        val userOutput = userDtoMapper.toDto(output)
        return LoginOutputDto(userOutput, "")
    }

    override fun fromDto(input: LoginInputDTO): UserModel {
        return UserModel(
            name = input.email,
            password = input.password,
            email = "",
            id = 0,
            birthDate = Clock.System.todayAt(TimeZone.currentSystemDefault())
        )
    }
}