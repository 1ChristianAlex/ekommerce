package store.com.domain.user.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class UserModel(val name: String, val email: String, val birthDate: LocalDateTime, val id: Int)