package store.com.adapter.`in`.http.controller.catalog.dto.mapper

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import store.com.adapter.`in`.http.controller.catalog.dto.ProductImageInputDto
import store.com.adapter.`in`.http.controller.catalog.dto.ProductImageOutputDto
import store.com.application.catalog.port.dto.ProductImagesDtoMapper
import store.com.domain.catalog.model.ProductImage


class ProductImagesDtoMapperImpl : ProductImagesDtoMapper() {
    override fun toDto(output: ProductImage): ProductImageOutputDto {
        return output.run {
            ProductImageOutputDto(
                id = id,
                name = name,
                urlSource = urlSource
            )

        }
    }

    override fun fromDto(input: ProductImageInputDto): ProductImage {
        return input.run {
            ProductImage(
                id = id ?: 0,
                name = name,
                urlSource = urlSource,
                createdAt = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()),
                updatedAt = null
            )
        }
    }
}