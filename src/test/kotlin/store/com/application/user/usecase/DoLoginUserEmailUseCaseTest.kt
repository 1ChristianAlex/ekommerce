package store.com.application.user.usecase

import kotlinx.coroutines.runBlocking
import kotlinx.datetime.LocalDate
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import store.com.adapter.`in`.http.controller.auth.dto.LoginDtoMapper
import store.com.adapter.`in`.http.controller.auth.dto.LoginInputDTO
import store.com.adapter.`in`.http.controller.auth.dto.LoginOutputDto
import store.com.adapter.`in`.http.controller.user.dto.UserDtoMapper
import store.com.application.core.auth.JwtService
import store.com.application.user.port.DoLoginUserEmailUseCase
import store.com.domain.user.model.User
import store.com.domain.user.service.LoginService
import kotlin.test.BeforeTest
import kotlin.test.Test

class DoLoginUserEmailUseCaseTest {
    private lateinit var doLoginUserEmailUseCase: DoLoginUserEmailUseCase


    @Mock
    private lateinit var _loginService: LoginService

    @Mock
    private lateinit var jwtService: JwtService

    private val loginDtoMapper = LoginDtoMapper(UserDtoMapper())


    @BeforeTest
    fun setUp() {
        MockitoAnnotations.openMocks(this)

        doLoginUserEmailUseCase = DoLoginUserEmailUseCaseImpl(_loginService, jwtService, loginDtoMapper)
    }

    @Test
    fun `should get user by login and generate token`(): Unit = runBlocking {
        val email = "christian.alexsander@outlook.com"
        val password = "4545454"
        val token = "token-generated"

        val user = User(
            password = password,
            email = email,
            name = "Christian Alexsander",
            id = 12,
            birthDate = LocalDate(
                1999, 7, 13
            )
        )

        Mockito.`when`(_loginService.doLoginWithEmail(email, password)).thenReturn(user)

        Mockito.`when`(jwtService.generateToken(loginDtoMapper.toDto(user).user)).thenReturn(token)

        val result = doLoginUserEmailUseCase.execute(LoginInputDTO(email, password))

        assert(result.data is LoginOutputDto)
        assert(result.data?.token == token)
    }
}