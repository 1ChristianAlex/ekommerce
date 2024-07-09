package store.com.adapter.`in`.http.controller.auth.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginInputDTO(val email: String, val password: String)