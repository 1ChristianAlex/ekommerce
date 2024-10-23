package store.com.application.user.port

import store.com.application.core.BaseUseCase
import store.com.domain.user.model.User

abstract class CreateNewUserUseCase : BaseUseCase<User, User>()