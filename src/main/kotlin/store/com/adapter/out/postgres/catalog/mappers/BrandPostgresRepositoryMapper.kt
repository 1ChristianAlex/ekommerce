package store.com.adapter.out.postgres.catalog.mappers

import store.com.adapter.out.postgres.model.BrandEntity
import store.com.adapter.out.postgres.model.ProductEntity
import store.com.application.catalog.port.repository.BrandRepositoryMapper
import store.com.application.catalog.port.repository.ProductRepositoryMapper
import store.com.domain.catalog.model.Brand

class BrandPostgresRepositoryMapper(private val productRepositoryMapper: ProductRepositoryMapper<ProductEntity>) :
    BrandRepositoryMapper<BrandEntity> {
    override fun toModel(input: BrandEntity): Brand {
        return input.run {
            Brand(
                id = id.value,
                name = name,
                createdAt = createdAt,
                updatedAt = updatedAt,
                productList = if (!productList.empty()) productList.map { productRepositoryMapper.toModel(it) } else listOf()
            )
        }
    }

    override fun fromModel(output: Brand): BrandEntity {
        throw Error("Cant be mapped to entity")
    }
}