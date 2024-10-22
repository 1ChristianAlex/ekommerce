package store.com.adapter.out.postgres.model


import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp


object MigrationTable : BaseTable("migrations.migration") {
    val time = timestamp("time")
    val name = text("name")
}

class MigrationEntity(id: EntityID<Int>) : BaseEntity(id) {
    companion object Factory : IntEntityClass<MigrationEntity>(MigrationTable)

    var time by MigrationTable.time
    var name by MigrationTable.name
    override var createdAt by MigrationTable.createdAt
    override var updatedAt by MigrationTable.updatedAt
}