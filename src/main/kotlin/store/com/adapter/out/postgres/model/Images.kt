package store.com.adapter.out.postgres.model


import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID


object ImagesTable : BaseTable("media.images") {
    val name = text("name")
    val urlSource = text("urlSource")
    val product = reference("productId", ProductTable)
}

class ImagesEntity(id: EntityID<Int>) : BaseEntity(id) {
    companion object Factory : IntEntityClass<ImagesEntity>(ImagesTable)

    var name by ImagesTable.name
    var urlSource by ImagesTable.urlSource
    var product by ProductEntity referencedOn ImagesTable.product
    override var createdAt by ImagesTable.createdAt
    override var updatedAt by ImagesTable.updatedAt
}