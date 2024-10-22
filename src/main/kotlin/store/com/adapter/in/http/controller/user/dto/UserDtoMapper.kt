package store.com.adapter.`in`.http.controller.user.dto

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import store.com.application.core.BaseDtoMapper
import store.com.domain.user.model.UserModel


class UserDtoMapper : BaseDtoMapper<UserInputDTO, UserOutputDto, UserModel>() {
    override fun toDto(output: UserModel): UserOutputDto {
        return output.let {
            UserOutputDto(
                name = it.name,
                email = it.email,
                id = it.id,
                birthDate = toUTCString(LocalDateTime(it.birthDate, LocalTime(6, 13, 0, 0)))
            )
        }
    }

    override fun fromDto(input: UserInputDTO): UserModel {
        return input.let {
            UserModel(
                name = it.name,
                email = it.email,
                id = it.id,
                birthDate = fromIsoString(it.birthDate).date,
                password = input.password,
            )
        }
    }
}