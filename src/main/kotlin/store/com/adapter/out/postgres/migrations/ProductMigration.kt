package store.com.adapter.out.postgres.migrations

import org.jetbrains.exposed.sql.Schema
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import store.com.adapter.out.postgres.model.ImagesEntity
import store.com.adapter.out.postgres.model.ImagesTable
import store.com.adapter.out.postgres.model.ProductEntity
import store.com.adapter.out.postgres.model.ProductTable

class ProductMigration : BaseMigration() {
    override val time: Long
        get() = 1729612498581

    override fun up() {
        transaction {
            SchemaUtils.createSchema(Schema("media"))
            SchemaUtils.createSchema(Schema("catalog"))

            SchemaUtils.create(ProductTable)
            SchemaUtils.create(ImagesTable)

        }
        transaction {
            val productTest = ProductEntity.new {
                name = "Test Product"
                price = 200.36
                description = "Testing product creation"
                stock = 15
                isActive = true
            }

            ImagesEntity.new {
                name = "Test Image"
                product = productTest
                urlSource = "https://picsum.photos/200/300"
            }
        }
        transaction {

        }
    }

    override fun down() {
        transaction {
            SchemaUtils.drop(ImagesTable)
            SchemaUtils.drop(ProductTable)
            SchemaUtils.dropSchema(Schema("media"))
            SchemaUtils.dropSchema(Schema("catalog"))
        }
    }
}