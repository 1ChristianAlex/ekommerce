package store.com.application.user.usecase

import store.com.application.user.port.CreateNewUserUseCase
import store.com.domain.user.model.UserModel
import store.com.domain.user.service.UserService

class CreateNewUserUseCaseImpl(private val userService: UserService) : CreateNewUserUseCase() {
    override suspend fun internalExecute(inputData: UserModel): UserModel {
        return userService.createNewUser(inputData)
    }

    override fun useCaseDescription(): String {
        return "Create new user and return the new one."
    }
}