package store.com.domain.catalog.model

import kotlinx.datetime.LocalDateTime

class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val stock: Int,

    val isActive: Boolean,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?,

    val images: List<ProductImage>,
    val categories: List<Category>,
    val brand: Brand?,
)