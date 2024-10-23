package store.com.application.catalog.port.repository

import store.com.application.core.BaseRepositoryMapper
import store.com.domain.catalog.model.ProductImage

interface ProductImageRepositoryMapper<EntityInput> : BaseRepositoryMapper<EntityInput, ProductImage>