package store.com.adapter.`in`.di

import org.koin.dsl.module
import store.com.adapter.`in`.http.controller.auth.LoginController
import store.com.adapter.`in`.http.controller.auth.dto.LoginDtoMapper
import store.com.adapter.`in`.http.controller.user.UserController
import store.com.adapter.`in`.http.controller.user.dto.UserDtoMapper
import store.com.adapter.out.postgres.model.UserEntity
import store.com.adapter.out.postgres.user.UserPostgresRepository
import store.com.adapter.out.postgres.user.UserPostgresRepositoryMapper
import store.com.application.core.auth.JwtService
import store.com.application.core.encrypt.PasswordEncrypt
import store.com.application.user.port.CreateNewUserUseCase
import store.com.application.user.port.DoLoginUserEmailUseCase
import store.com.application.user.port.UserRepository
import store.com.application.user.port.UserRepositoryMapper
import store.com.application.user.usecase.CreateNewUserUseCaseImpl
import store.com.application.user.usecase.DoLoginUserEmailUseCaseImpl
import store.com.domain.user.service.LoginService
import store.com.domain.user.service.UserService

val appModule = module {

    // auth

    single { JwtService() }

    // controllers
    single { LoginController(get()) }
    single { UserController(get(), get()) }

    // services
    single { LoginService(get(), get()) }
    single { UserService(get()) }

    // useCase
    single<DoLoginUserEmailUseCase> { DoLoginUserEmailUseCaseImpl(get(), get(), get()) }
    single<CreateNewUserUseCase> { CreateNewUserUseCaseImpl(get()) }

    // repository
    single<UserRepository> { UserPostgresRepository(get()) }
    single<UserRepositoryMapper<UserEntity>> { UserPostgresRepositoryMapper() }


    // Core
    single { PasswordEncrypt() }

    // mappers dto
    single { UserDtoMapper() }
    single { LoginDtoMapper(get()) }
}
