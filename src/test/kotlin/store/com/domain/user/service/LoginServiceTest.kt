package store.com.domain.user.service

import kotlinx.coroutines.runBlocking
import kotlinx.datetime.LocalDate
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import store.com.application.core.encrypt.PasswordEncrypt
import store.com.application.user.port.UserRepository
import store.com.domain.user.model.User
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class LoginServiceTest {

    private lateinit var loginService: LoginService

    @Mock
    private lateinit var userRepository: UserRepository

    private val passwordEncrypt = PasswordEncrypt()

    @BeforeTest
    fun setUp() {
        MockitoAnnotations.openMocks(this)

        loginService = LoginService(userRepository, passwordEncrypt)
    }

    @Test
    fun `should get an user by email and compare password`(): Unit = runBlocking {
        val email = "christian.alexsander@outlook.com"
        val password = "4545454"
        val passwordHashed = passwordEncrypt.hashPassword(password)

        val user = User(
            password = passwordHashed,
            email = email,
            name = "Christian Alexsander",
            id = 12,
            birthDate = LocalDate(
                1999, 7, 13
            )
        )
        Mockito.`when`(
            userRepository.findUserByEmail(
                email
            )
        ).thenReturn(
            user
        )

        val userResult = loginService.doLoginWithEmail(email, password)

        Mockito.verify(userRepository).findUserByEmail(email)
        assertEquals(userResult, user)
    }
}