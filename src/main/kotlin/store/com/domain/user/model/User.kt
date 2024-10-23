package store.com.domain.user.model

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class User(var name: String, var email: String, var birthDate: LocalDate, var id: Int, var password: String?)