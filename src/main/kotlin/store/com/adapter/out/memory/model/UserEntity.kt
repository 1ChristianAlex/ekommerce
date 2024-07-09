package store.com.adapter.out.memory.model

import kotlinx.datetime.LocalDateTime

data class UserEntity(
    val id: Int,
    val name: String,
    val email: String,
    val password: String?,
    val birthDate: LocalDateTime
)
