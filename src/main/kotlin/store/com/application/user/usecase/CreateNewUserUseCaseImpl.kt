package store.com.application.user.usecase

import store.com.application.user.port.CreateNewUserUseCase
import store.com.domain.user.model.User
import store.com.domain.user.service.UserService

class CreateNewUserUseCaseImpl(private val userService: UserService) : CreateNewUserUseCase() {
    override suspend fun internalExecute(inputData: User): User {
        return userService.createNewUser(inputData)
    }

    override fun useCaseDescription(): String {
        return "Create new user and return the new one."
    }
}