package store.com.application.user.usecase

import store.com.adapter.`in`.http.controller.auth.dto.LoginInputDTO
import store.com.application.core.BaseUseCase
import store.com.domain.user.model.UserModel
import store.com.domain.user.service.LoginService

class DoLoginUserEmailUseCase(private val _loginService: LoginService) : BaseUseCase<LoginInputDTO, UserModel>() {
    override suspend fun internalExecute(inputData: LoginInputDTO): UserModel {
        val doLoginWithEmail = _loginService.doLoginWithEmail(inputData.email, inputData.password)

        return doLoginWithEmail
    }

    override fun useCaseDescription() = "Try to do login with user email and password."
}