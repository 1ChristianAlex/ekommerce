package store.com.application.user.usecase

import store.com.adapter.`in`.http.controller.auth.dto.LoginDtoMapper
import store.com.adapter.`in`.http.controller.auth.dto.LoginInputDTO
import store.com.adapter.`in`.http.controller.auth.dto.LoginOutputDto
import store.com.application.core.auth.JwtService
import store.com.application.user.port.DoLoginUserEmailUseCase
import store.com.domain.user.service.LoginService

class DoLoginUserEmailUseCaseImpl(
    private val _loginService: LoginService,
    private val jwtService: JwtService,
    private val loginDtoMapper: LoginDtoMapper
) : DoLoginUserEmailUseCase() {
    override suspend fun internalExecute(inputData: LoginInputDTO): LoginOutputDto {
        val doLoginWithEmail = _loginService.doLoginWithEmail(inputData.email, inputData.password)
        val loginOutputDto = loginDtoMapper.toDto(doLoginWithEmail)

        loginOutputDto.token = jwtService.generateToken(loginOutputDto.user)

        return loginOutputDto
    }

    override fun useCaseDescription() = "Try to do login with user email and password."
}