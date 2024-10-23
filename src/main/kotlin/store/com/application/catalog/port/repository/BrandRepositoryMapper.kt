package store.com.application.catalog.port.repository

import store.com.application.core.BaseRepositoryMapper
import store.com.domain.catalog.model.Brand

interface BrandRepositoryMapper<EntityInput>  : BaseRepositoryMapper<EntityInput, Brand>