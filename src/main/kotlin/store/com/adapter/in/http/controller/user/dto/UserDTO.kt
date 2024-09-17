package store.com.adapter.`in`.http.controller.user.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserInputDTO(
    val name: String,
    val email: String,
    val password: String,
    val birthDate: String,
    val id: Int,
)

@Serializable
data class UserOutputDto(
    val name: String,
    val email: String,
    val birthDate: String,
    val id: Int
)