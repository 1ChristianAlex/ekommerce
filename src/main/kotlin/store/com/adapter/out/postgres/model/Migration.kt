package store.com.adapter.out.postgres.model

import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.BaseTable
import org.ktorm.schema.datetime
import org.ktorm.schema.int
import org.ktorm.schema.varchar
import java.time.LocalDateTime

data class MigrationEntity(
    val id: Int,
    val time: LocalDateTime,
    val name: String
)


object MigrationTable : BaseTable<MigrationEntity>("migration", "mgt", null, "migration") {
    val id = int("id").primaryKey()
    val time = datetime("time")
    val name = varchar("name")

    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean) = MigrationEntity(
        id = row[id] ?: 0,
        name = row[name].orEmpty(),
        time = row[time] ?: LocalDateTime.now(),
    )
}