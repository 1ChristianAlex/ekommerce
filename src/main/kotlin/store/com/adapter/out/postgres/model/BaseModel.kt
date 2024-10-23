package store.com.adapter.out.postgres.model

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.CurrentDateTime
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

open class BaseTable(tableName: String) : IntIdTable(tableName) {
    val createdAt = datetime("createdAt").defaultExpression(CurrentDateTime)
    val updatedAt = datetime("updatedAt").nullable()
}

abstract class BaseEntity(id: EntityID<Int>) : IntEntity(id) {
    abstract var createdAt: LocalDateTime
    abstract var updatedAt: LocalDateTime?
}