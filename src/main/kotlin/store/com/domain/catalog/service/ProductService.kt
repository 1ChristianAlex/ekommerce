package store.com.domain.catalog.service

import store.com.application.catalog.port.repository.ProductRepository
import store.com.domain.catalog.model.Product

class ProductService(private val productRepository: ProductRepository) {
    suspend fun listProducts(): List<Product> {
        return productRepository.listProducts()
    }
}