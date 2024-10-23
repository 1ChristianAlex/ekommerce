package store.com.adapter.`in`.http.controller.catalog.dto

import kotlinx.serialization.Serializable

@Serializable
data class BrandOutputDto(
    val id: Int,
    val name: String,
    val productList: List<ProductOutputDto>? = listOf()
)

@Serializable
data class BrandInputDto(
    val id: Int?,
    val name: String,
    val productIds: List<Int>
)