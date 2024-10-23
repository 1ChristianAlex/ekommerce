package store.com.adapter.`in`.http.controller.catalog.dto.mapper

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import store.com.adapter.`in`.http.controller.catalog.dto.CategoryInputDto
import store.com.adapter.`in`.http.controller.catalog.dto.CategoryOutputDto
import store.com.application.catalog.port.dto.CategoryDtoMapper
import store.com.application.catalog.port.dto.ProductDtoMapper
import store.com.domain.catalog.model.Category
import store.com.domain.catalog.model.Product


class CategoryDtoMapperImpl(
    private val productDtoMapper: ProductDtoMapper
) :
    CategoryDtoMapper() {
    override fun toDto(output: Category): CategoryOutputDto {
        return output.run {
            CategoryOutputDto(
                productList = if (productList.isNotEmpty()) productList.map { productDtoMapper.toDto(it) } else listOf(),
                id = id,
                name = name
            )
        }
    }

    override fun fromDto(input: CategoryInputDto): Category {
        val clockNow = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        return input.run {
            Category(
                id = id ?: 0,
                name = name,
                description = description,
                updatedAt = null,
                createdAt = clockNow,
                productList = if (productIds.isNotEmpty()) productIds.map {
                    Product(
                        it, "", "", 0.0, 0, false,
                        clockNow,
                        null, listOf(), listOf(), null
                    )
                } else listOf()
            )
        }
    }


}