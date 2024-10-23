package store.com.adapter.`in`.di

import org.koin.dsl.module
import store.com.adapter.`in`.http.controller.auth.LoginController
import store.com.adapter.`in`.http.controller.auth.dto.LoginDtoMapper
import store.com.adapter.`in`.http.controller.catalog.ProductController
import store.com.adapter.`in`.http.controller.catalog.dto.mapper.BrandDtoMapperImpl
import store.com.adapter.`in`.http.controller.catalog.dto.mapper.CategoryDtoMapperImpl
import store.com.adapter.`in`.http.controller.catalog.dto.mapper.ProductDtoMapperImpl
import store.com.adapter.`in`.http.controller.catalog.dto.mapper.ProductImagesDtoMapperImpl
import store.com.adapter.`in`.http.controller.user.UserController
import store.com.adapter.`in`.http.controller.user.dto.UserDtoMapper
import store.com.adapter.out.postgres.catalog.mappers.BrandPostgresRepositoryMapper
import store.com.adapter.out.postgres.catalog.mappers.CategoryPostgresRepositoryMapper
import store.com.adapter.out.postgres.catalog.mappers.ProductImagePostgresRepositoryMapper
import store.com.adapter.out.postgres.catalog.mappers.ProductPostgresRepositoryMapper
import store.com.adapter.out.postgres.catalog.repository.ProductPostgresRepository
import store.com.adapter.out.postgres.model.*
import store.com.adapter.out.postgres.user.UserPostgresRepository
import store.com.adapter.out.postgres.user.UserPostgresRepositoryMapper
import store.com.application.catalog.port.dto.BrandDtoMapper
import store.com.application.catalog.port.dto.CategoryDtoMapper
import store.com.application.catalog.port.dto.ProductDtoMapper
import store.com.application.catalog.port.dto.ProductImagesDtoMapper
import store.com.application.catalog.port.repository.*
import store.com.application.catalog.port.usecase.GetProductListUseCase
import store.com.application.catalog.usecase.GetProductListUseCaseImpl
import store.com.application.core.auth.JwtService
import store.com.application.core.encrypt.PasswordEncrypt
import store.com.application.user.port.CreateNewUserUseCase
import store.com.application.user.port.DoLoginUserEmailUseCase
import store.com.application.user.port.UserRepository
import store.com.application.user.port.UserRepositoryMapper
import store.com.application.user.usecase.CreateNewUserUseCaseImpl
import store.com.application.user.usecase.DoLoginUserEmailUseCaseImpl
import store.com.domain.catalog.service.ProductService
import store.com.domain.user.service.LoginService
import store.com.domain.user.service.UserService

val appModule = module {

    // auth
    single { JwtService() }

    // controllers
    single { LoginController(get()) }
    single { UserController(get(), get()) }
    single { ProductController(get()) }

    // services
    single { LoginService(get(), get()) }
    single { UserService(get()) }
    single { ProductService(get()) }
    // useCase
    single<DoLoginUserEmailUseCase> { DoLoginUserEmailUseCaseImpl(get(), get(), get()) }
    single<CreateNewUserUseCase> { CreateNewUserUseCaseImpl(get()) }
    single<GetProductListUseCase> { GetProductListUseCaseImpl(get(), get()) }

    // repository
    single<UserRepository> { UserPostgresRepository(get()) }
    single<UserRepositoryMapper<UserEntity>> { UserPostgresRepositoryMapper() }
    single<BrandRepositoryMapper<BrandEntity>> { BrandPostgresRepositoryMapper(get()) }
    single<CategoryRepositoryMapper<CategoriesEntity>> { CategoryPostgresRepositoryMapper(get()) }
    single<ProductImageRepositoryMapper<ImagesEntity>> { ProductImagePostgresRepositoryMapper() }
    single<ProductRepositoryMapper<ProductEntity>> { ProductPostgresRepositoryMapper(get()) }
    single<ProductRepository> { ProductPostgresRepository(get()) }

    // Core
    single { PasswordEncrypt() }

    // mappers dto
    single { UserDtoMapper() }
    single { LoginDtoMapper(get()) }
    single<ProductImagesDtoMapper> { ProductImagesDtoMapperImpl() }
    single<BrandDtoMapper> { BrandDtoMapperImpl(get()) }
    single<CategoryDtoMapper> { CategoryDtoMapperImpl(get()) }
    single<ProductDtoMapper> { ProductDtoMapperImpl(get()) }
}
