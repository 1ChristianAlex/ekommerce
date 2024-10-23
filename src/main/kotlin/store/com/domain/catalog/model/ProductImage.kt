package store.com.domain.catalog.model

import kotlinx.datetime.LocalDateTime

class ProductImage(
    val id: Int,
    val name: String,
    val urlSource: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,
)