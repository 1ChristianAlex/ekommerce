package store.com.adapter.out.postgres.catalog.mappers

import store.com.adapter.out.postgres.model.CategoriesEntity
import store.com.adapter.out.postgres.model.ProductEntity
import store.com.application.catalog.port.repository.CategoryRepositoryMapper
import store.com.application.catalog.port.repository.ProductRepositoryMapper
import store.com.domain.catalog.model.Category

class CategoryPostgresRepositoryMapper(private val productRepositoryMapper: ProductRepositoryMapper<ProductEntity>) :
    CategoryRepositoryMapper<CategoriesEntity> {
    override fun toModel(input: CategoriesEntity): Category {
        return input.run {
            Category(
                id = id.value,
                name = name,
                createdAt = createdAt,
                updatedAt = updatedAt,
                description = description,
                productList = if (!productList.empty()) productList.map { productRepositoryMapper.toModel(it) } else listOf()
            )
        }
    }

    override fun fromModel(output: Category): CategoriesEntity {
        throw Error("Cant be mapped to entity")
    }
}