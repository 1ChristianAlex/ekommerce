package store.com.application.user.port

import store.com.application.core.BaseUseCase
import store.com.domain.user.model.UserModel

abstract class CreateNewUserUseCase : BaseUseCase<UserModel, UserModel>() {
}