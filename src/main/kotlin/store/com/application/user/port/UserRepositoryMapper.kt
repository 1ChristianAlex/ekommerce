package store.com.application.user.port

import store.com.application.core.BaseRepositoryMapper
import store.com.domain.user.model.User

interface UserRepositoryMapper <TInput> : BaseRepositoryMapper<TInput, User>