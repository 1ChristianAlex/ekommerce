package store.com.adapter.out.postgres.catalog.mappers

import store.com.adapter.out.postgres.model.ImagesEntity
import store.com.application.catalog.port.repository.ProductImageRepositoryMapper
import store.com.domain.catalog.model.ProductImage

class ProductImagePostgresRepositoryMapper : ProductImageRepositoryMapper<ImagesEntity> {
    override fun toModel(input: ImagesEntity): ProductImage {
        return ProductImage(
            id = input.id.value,
            name = input.name,
            createdAt = input.createdAt,
            updatedAt = input.updatedAt,
            urlSource = input.urlSource
        )
    }

    override fun fromModel(output: ProductImage): ImagesEntity {
        throw Error("Cant be mapped to entity")
    }
}