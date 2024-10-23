package store.com.adapter.out.postgres.catalog.repository

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.SizedCollection
import org.jetbrains.exposed.sql.transactions.transaction
import store.com.adapter.out.postgres.model.*
import store.com.application.catalog.port.repository.ProductRepository
import store.com.application.catalog.port.repository.ProductRepositoryMapper
import store.com.domain.catalog.model.Product

class ProductPostgresRepository(private val productRepositoryMapper: ProductRepositoryMapper<ProductEntity>) :
    ProductRepository {
    override suspend fun getProductById(id: Int): Product {
        val productFind = transaction {
            ProductEntity.findById(id)
        }

        if (productFind == null) {
            throw Error("Product id $id does not exist")
        }

        return productRepositoryMapper.toModel(productFind)
    }

    override suspend fun listProducts(): List<Product> {
        val productList = transaction { ProductEntity.all().toList().map { productRepositoryMapper.toModel(it) } }

        return productList
    }

    override suspend fun registerNewProduct(product: Product): Product {
        val productCreated = transaction {
            val newProduct = ProductEntity.new {
                name = product.name
                createdAt = product.createdAt
                updatedAt = product.updatedAt
                description = product.description
                brand = BrandEntity(EntityID(product.brand?.id ?: 0, BrandTable))
                categories =
                    SizedCollection(product.categories.map { CategoriesEntity(EntityID(it.id, CategoriesTable)) })
                price = product.price
                stock = product.stock
                isActive = product.isActive
            }

            newProduct
        }

        return productRepositoryMapper.toModel(productCreated)
    }

    override suspend fun updateProduct(id: Int, product: Product): Product {
        val productCreated = transaction {

            val newProduct = ProductEntity.findByIdAndUpdate(id) { productUpdate ->
                productUpdate.name = product.name
                productUpdate.createdAt = product.createdAt
                productUpdate.updatedAt = product.updatedAt
                productUpdate.description = product.description
                productUpdate.brand = BrandEntity(EntityID(product.brand?.id ?: 0, BrandTable))
                productUpdate.categories =
                    SizedCollection(product.categories.map { CategoriesEntity(EntityID(it.id, CategoriesTable)) })
                productUpdate.price = product.price
                productUpdate.stock = product.stock
                productUpdate.isActive = product.isActive
            }

            newProduct
        }

        if (productCreated == null) {
            throw Error("Product id $id does not exist")
        }

        return productRepositoryMapper.toModel(productCreated)
    }
}