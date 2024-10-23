package store.com.adapter.out.postgres.catalog.mappers

import store.com.adapter.out.postgres.model.ImagesEntity
import store.com.adapter.out.postgres.model.ProductEntity
import store.com.application.catalog.port.repository.ProductImageRepositoryMapper
import store.com.application.catalog.port.repository.ProductRepositoryMapper
import store.com.domain.catalog.model.Brand
import store.com.domain.catalog.model.Category
import store.com.domain.catalog.model.Product

class ProductPostgresRepositoryMapper(
    private val productImageRepositoryMapper: ProductImageRepositoryMapper<ImagesEntity>
) : ProductRepositoryMapper<ProductEntity> {
    override fun toModel(input: ProductEntity): Product {
        return input.run {
            Product(
                id = id.value,
                name = name,
                createdAt = createdAt,
                updatedAt = updatedAt,
                description = description,
                brand = Brand(
                    name = brand.name,
                    updatedAt = brand.updatedAt,
                    createdAt = brand.createdAt,
                    id = brand.id.value
                ),
                categories = if (!categories.empty()) categories.map {
                    Category(
                        name = it.name,
                        updatedAt = it.updatedAt,
                        createdAt = it.createdAt,
                        id = it.id.value,
                        description = it.description
                    )
                } else listOf(),
                price = price,
                stock = stock,
                images = images.map { productImageRepositoryMapper.toModel(it) },
                isActive = isActive,
            )
        }
    }

    override fun fromModel(output: Product): ProductEntity {
        throw Error("Cant be mapped to entity")
    }
}