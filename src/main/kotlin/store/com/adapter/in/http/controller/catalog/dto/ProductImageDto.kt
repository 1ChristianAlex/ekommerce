package store.com.adapter.`in`.http.controller.catalog.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProductImageOutputDto(
    val id: Int,
    val name: String,
    val urlSource: String,
)

@Serializable
data class ProductImageInputDto(
    val id: Int?,
    val productId: Int,
    val name: String,
    val urlSource: String,
)