package store.com.adapter.`in`.http.controller.catalog.dto.mapper

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import store.com.adapter.`in`.http.controller.catalog.dto.BrandInputDto
import store.com.adapter.`in`.http.controller.catalog.dto.BrandOutputDto
import store.com.application.catalog.port.dto.BrandDtoMapper
import store.com.application.catalog.port.dto.ProductDtoMapper
import store.com.domain.catalog.model.Brand
import store.com.domain.catalog.model.Product


class BrandDtoMapperImpl(private val productDtoMapper: ProductDtoMapper) :
    BrandDtoMapper() {
    override fun toDto(output: Brand): BrandOutputDto {
        return output.run {
            BrandOutputDto(
                id = id,
                name = name,
                productList = if (productList.isNotEmpty()) productList.map { productDtoMapper.toDto(it) } else listOf()
            )
        }
    }

    override fun fromDto(input: BrandInputDto): Brand {
        val clockNow = Clock.System.now().toLocalDateTime(
            TimeZone.currentSystemDefault()
        )
        return input.run {
            Brand(
                id = id ?: 0,
                name = name,
                productList = if (productIds.isNotEmpty()) productIds.map {
                    Product(
                        it, "", "", 0.0, 0, false,
                        clockNow,
                        null, listOf(), listOf(), null
                    )
                } else listOf(),
                updatedAt = null,
                createdAt = clockNow
            )

        }
    }

}