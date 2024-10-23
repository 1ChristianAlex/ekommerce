package store.com.domain.catalog.model

import kotlinx.datetime.LocalDateTime

class Category(
    val id: Int,
    val name: String,
    val description: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,
    val productList: List<Product> = listOf()
)