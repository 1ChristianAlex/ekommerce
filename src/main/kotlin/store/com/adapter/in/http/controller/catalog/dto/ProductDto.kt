package store.com.adapter.`in`.http.controller.catalog.dto

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class ProductOutputDto(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val stock: Int,

    val isActive: Boolean,
    val createdAt: LocalDateTime,

    val images: List<ProductImageOutputDto>?,
    val categories: List<CategoryOutputDto>?,
    val brand: BrandOutputDto?,
)

@Serializable
data class ProductInputDto(
    val id: Int?,
    val name: String,
    val description: String,
    val price: Double,
    val stock: Int,

    val isActive: Boolean,

    val categoriesIds: List<Int>,
    val brandId: Int,
)