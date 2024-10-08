package store.com.adapter.out.postgres.model


import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.date


object MigrationTable : IntIdTable("migration.migration") {
    val time = date("time")
    val name = text("name")
}

class MigrationEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object Factory: IntEntityClass<MigrationEntity>(MigrationTable)
    var time by MigrationTable.time
    var name by MigrationTable.name
}