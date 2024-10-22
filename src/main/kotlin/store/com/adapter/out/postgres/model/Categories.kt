package store.com.adapter.out.postgres.model


import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID


object CategoriesTable : BaseTable("catalog.categories") {
    val name = text("name")
    val description = text("description")
}

class CategoriesEntity(id: EntityID<Int>) : BaseEntity(id) {
    companion object Factory : IntEntityClass<CategoriesEntity>(CategoriesTable)

    var name by CategoriesTable.name
    var description by CategoriesTable.description
    var products by ProductEntity via CategoriesProductTable

    override var createdAt by CategoriesTable.createdAt
    override var updatedAt by CategoriesTable.updatedAt
}