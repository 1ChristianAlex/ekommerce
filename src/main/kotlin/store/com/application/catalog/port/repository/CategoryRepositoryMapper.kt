package store.com.application.catalog.port.repository

import store.com.application.core.BaseRepositoryMapper
import store.com.domain.catalog.model.Category

interface CategoryRepositoryMapper<EntityInput> : BaseRepositoryMapper<EntityInput, Category>