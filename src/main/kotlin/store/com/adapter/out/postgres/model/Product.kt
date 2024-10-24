package store.com.adapter.out.postgres.model


import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID


object ProductTable : BaseTable("catalog.product") {
    val name = text("name")
    val description = text("description")
    val price = double("price")
    val stock = integer("stock")
    val isActive = bool("isActive")
    val brand = reference("brandId", BrandTable)

}

class ProductEntity(id: EntityID<Int>) : BaseEntity(id) {
    companion object Factory : IntEntityClass<ProductEntity>(ProductTable)

    var name by ProductTable.name
    var description by ProductTable.description
    var price by ProductTable.price
    var stock by ProductTable.stock

    var isActive by ProductTable.isActive
    override var createdAt by ProductTable.createdAt
    override var updatedAt by ProductTable.updatedAt

    val images by ImagesEntity referrersOn ImagesTable.product
    var categories by CategoriesEntity via CategoriesProductTable
    var brand by BrandEntity referencedOn ProductTable.brand
}