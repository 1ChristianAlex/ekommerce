package store.com.domain.user.model

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class LoginModelTest {

    private val _password = "12345"
    private val _email = "christian.alexsander@outlook.com"
    private val loginModel = LoginModel(_email, _password)

    @Test
    fun `should validated email`() {
        assertTrue(loginModel.isEmailValid(), "Is email valid")
        assertFalse(LoginModel("christian.alexsander", _password).isEmailValid(), "Is email valid")
    }

    @Test
    fun `should validated password`() {
        assertFalse(LoginModel("christian.alexsander", "").isPasswordValid(), "Is email valid")
    }

    @Test
    fun `getter should return email and password`() {
        assert(_password == loginModel.password)
        assert(_email == loginModel.email)
    }
}