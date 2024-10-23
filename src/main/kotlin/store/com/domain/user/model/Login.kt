package store.com.domain.user.model

class Login(private val _email: String, private val _password: String) {
    fun isEmailValid(): Boolean = "@" in _email

    fun isPasswordValid(): Boolean = _password.isNotEmpty()

    val email get() = _email
    val password get() = _password
}