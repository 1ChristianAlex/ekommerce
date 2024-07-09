package store.com.adapter.`in`.di

import org.koin.dsl.module
import store.com.adapter.`in`.http.controller.auth.LoginController
import store.com.adapter.`in`.http.controller.auth.dto.LoginInputDTO
import store.com.adapter.out.memory.model.UserEntity
import store.com.adapter.out.memory.user.UserMemoryRepository
import store.com.application.core.BaseUseCase
import store.com.adapter.out.memory.user.UserMemoryRepositoryMapper
import store.com.application.user.port.UserRepository
import store.com.application.user.port.UserRepositoryMapper
import store.com.application.user.usecase.DoLoginUserEmailUseCase
import store.com.domain.user.model.UserModel
import store.com.domain.user.service.LoginService

val moduleA = module {
//    controllers
    single { LoginController(get()) }

//    services
    single { LoginService(get()) }

//    useCase
    single<BaseUseCase<LoginInputDTO, UserModel>> { DoLoginUserEmailUseCase(get()) }

//    repository
    single<UserRepository> { UserMemoryRepository(get()) }

//    mappers
    single<UserRepositoryMapper<UserEntity>> { UserMemoryRepositoryMapper() }

}