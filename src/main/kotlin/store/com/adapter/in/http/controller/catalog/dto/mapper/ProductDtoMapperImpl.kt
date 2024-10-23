package store.com.adapter.`in`.http.controller.catalog.dto.mapper

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import store.com.adapter.`in`.http.controller.catalog.dto.BrandOutputDto
import store.com.adapter.`in`.http.controller.catalog.dto.CategoryOutputDto
import store.com.adapter.`in`.http.controller.catalog.dto.ProductInputDto
import store.com.adapter.`in`.http.controller.catalog.dto.ProductOutputDto
import store.com.application.catalog.port.dto.ProductDtoMapper
import store.com.application.catalog.port.dto.ProductImagesDtoMapper
import store.com.domain.catalog.model.Brand
import store.com.domain.catalog.model.Category
import store.com.domain.catalog.model.Product


class ProductDtoMapperImpl(
    private val productImagesDtoMapper: ProductImagesDtoMapper,
) :
    ProductDtoMapper() {
    override fun toDto(output: Product): ProductOutputDto {
        return output.run {
            ProductOutputDto(
                id = id,
                name = name,
                isActive = isActive,
                images = if (images.isNotEmpty()) images.map { productImagesDtoMapper.toDto(it) } else listOf(),
                description = description,
                price = price,
                stock = stock,
                createdAt = createdAt,
                brand = brand?.let { BrandOutputDto(
                    id = it.id,
                    name = it.name,
                    productList = listOf()
                ) },
                categories = if (categories.isNotEmpty()) categories.map {
                    CategoryOutputDto(
                        id = it.id,
                        name = it.name,
                        productList = listOf()
                    )
                } else listOf()
            )
        }
    }

    override fun fromDto(input: ProductInputDto): Product {
        return input.run {
            val timeNow = Clock.System.now().toLocalDateTime(
                TimeZone.currentSystemDefault()
            )
            Product(
                id = id ?: 0,
                name = name,
                price = price,
                stock = stock,
                brand = Brand(brandId, "", timeNow, null),
                updatedAt = null,
                description = description,
                createdAt = timeNow,
                images = listOf(),
                isActive = isActive,
                categories = if (categoriesIds.isNotEmpty()) categoriesIds.map {
                    Category(
                        it,
                        "",
                        "",
                        timeNow,
                        null
                    )
                } else listOf()
            )
        }
    }

}