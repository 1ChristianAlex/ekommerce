package store.com.adapter.out.postgres.migrations

import org.jetbrains.exposed.sql.Schema
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.SizedCollection
import org.jetbrains.exposed.sql.transactions.transaction
import store.com.adapter.out.postgres.model.*

class ProductMigration : BaseMigration() {
    override val time: Long
        get() = 1729612498581

    override fun up() {
        transaction {
            SchemaUtils.createSchema(Schema("media"))
            SchemaUtils.createSchema(Schema("catalog"))

            SchemaUtils.create(ProductTable)
            SchemaUtils.create(BrandTable)
            SchemaUtils.create(CategoriesTable)
            SchemaUtils.create(CategoriesProductTable)
            SchemaUtils.create(ImagesTable)

        }
        transaction {

            val branchItem = BrandEntity.new {
                name = "Nike"
            }

            val newCategory = CategoriesEntity.new {
                name = "Category Test"
                description = "Test Category"
            }

            val productTest = ProductEntity.new {
                name = "Test Product"
                price = 200.36
                description = "Testing product creation"
                stock = 15
                isActive = true
                categories = SizedCollection(listOf(newCategory))
                brand = branchItem
            }

            ImagesEntity.new {
                name = "Test Image"
                product = productTest
                urlSource = "https://picsum.photos/200/300"
            }
        }

    }

    override fun down() {
        transaction {
            SchemaUtils.dropSchema(Schema("media"))
            SchemaUtils.dropSchema(Schema("catalog"))

            SchemaUtils.drop(ProductTable)
            SchemaUtils.drop(BrandTable)
            SchemaUtils.drop(CategoriesTable)
            SchemaUtils.drop(CategoriesProductTable)
            SchemaUtils.drop(ImagesTable)
        }
    }
}