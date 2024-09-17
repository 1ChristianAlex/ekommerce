package store.com.application.user.port

import store.com.application.core.BaseRepositoryMapper
import store.com.domain.user.model.UserModel

interface LoginRepositoryMapper<TInput> : BaseRepositoryMapper<TInput, UserModel>