package store.com.adapter.`in`.http.controller.auth.dto

import kotlinx.serialization.Serializable
import store.com.adapter.`in`.http.controller.user.dto.UserOutputDto

@Serializable
data class LoginInputDTO(val email: String, val password: String)

@Serializable
data class LoginOutputDto(val user: UserOutputDto, var token: String)