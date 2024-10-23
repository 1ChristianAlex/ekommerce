package store.com.adapter.`in`.http.controller.catalog.dto

import kotlinx.serialization.Serializable

@Serializable
data class CategoryOutputDto(
    val id: Int,
    val name: String,
    val productList: List<ProductOutputDto>? = listOf()
)

@Serializable
data class CategoryInputDto(
    val id: Int?,
    val name: String,
    val description: String,
    val productIds: List<Int>
)