package store.com.adapter.`in`.di

import org.koin.dsl.module
import store.com.adapter.`in`.http.controller.auth.LoginController
import store.com.adapter.`in`.http.controller.auth.dto.LoginInputDTO
import store.com.adapter.`in`.http.controller.user.UserController
import store.com.adapter.`in`.http.controller.user.dto.UserDtoMapper
import store.com.adapter.`in`.http.controller.user.dto.UserInputDTO
import store.com.adapter.`in`.http.controller.user.dto.UserOutputDto
import store.com.adapter.out.postgres.model.UserEntity
import store.com.adapter.out.postgres.user.UserPostgresRepository
import store.com.adapter.out.postgres.user.UserPostgresRepositoryMapper
import store.com.application.core.BaseDtoMapper
import store.com.application.core.BaseUseCase
import store.com.application.user.port.UserRepository
import store.com.application.user.port.UserRepositoryMapper
import store.com.application.user.usecase.CreateNewUserUseCase
import store.com.application.user.usecase.DoLoginUserEmailUseCase
import store.com.domain.user.model.UserModel
import store.com.domain.user.service.LoginService
import store.com.domain.user.service.UserService

val appModule = module {
    // controllers
    single { LoginController(get()) }
    single { UserController(get(), get()) }

    // services
    single { LoginService(get()) }
    single { UserService(get()) }

    // useCase
    single<BaseUseCase<LoginInputDTO, UserModel>> { DoLoginUserEmailUseCase(get()) }
    single<BaseUseCase<UserModel, UserModel>> { CreateNewUserUseCase(get()) }
    // repository
    single<UserRepository> { UserPostgresRepository(get(), get()) }
    single<UserRepositoryMapper<UserEntity>> { UserPostgresRepositoryMapper() }


    // mappers
    single<BaseDtoMapper<UserInputDTO, UserOutputDto, UserModel>> { UserDtoMapper() }
}
