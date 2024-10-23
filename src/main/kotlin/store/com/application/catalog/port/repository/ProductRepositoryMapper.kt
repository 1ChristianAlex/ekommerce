package store.com.application.catalog.port.repository

import store.com.application.core.BaseRepositoryMapper
import store.com.domain.catalog.model.Product

interface ProductRepositoryMapper<EntityInput>  : BaseRepositoryMapper<EntityInput, Product>