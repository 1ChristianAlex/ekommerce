package store.com.application.catalog.port.repository

import store.com.domain.catalog.model.Product

interface ProductRepository {
    suspend fun getProductById(id: Int): Product
    suspend fun listProducts(): List<Product>
    suspend fun registerNewProduct(product: Product): Product
    suspend fun updateProduct(id: Int, product: Product): Product
}