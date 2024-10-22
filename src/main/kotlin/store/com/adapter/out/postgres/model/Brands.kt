package store.com.adapter.out.postgres.model


import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID


object BrandTable : BaseTable("catalog.brand") {
    val name = text("name")
}

class BrandEntity(id: EntityID<Int>) : BaseEntity(id) {
    companion object Factory : IntEntityClass<BrandEntity>(BrandTable)

    var name by BrandTable.name

    override var createdAt by BrandTable.createdAt
    override var updatedAt by BrandTable.updatedAt

    val product by ProductEntity referrersOn ProductTable
}