package store.com.application.user.port

import store.com.adapter.`in`.http.controller.auth.dto.LoginInputDTO
import store.com.adapter.`in`.http.controller.auth.dto.LoginOutputDto
import store.com.application.core.BaseUseCase

abstract class DoLoginUserEmailUseCase : BaseUseCase<LoginInputDTO, LoginOutputDto>()