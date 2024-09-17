package store.com.adapter.out.postgres.migrations

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn
import org.jetbrains.exposed.sql.Schema
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import store.com.adapter.out.postgres.model.MigrationEntity
import store.com.adapter.out.postgres.model.MigrationTable
import store.com.adapter.out.postgres.model.UserEntity
import store.com.adapter.out.postgres.model.UserTable

class InitialMigration() : BaseMigration() {
    override fun up() {
       transaction {
           SchemaUtils.createSchema(Schema("migration"))
           SchemaUtils.createSchema(Schema("user"))

           SchemaUtils.create(MigrationTable)
           SchemaUtils.create(UserTable)

           MigrationEntity.new {
               name = className
               time = Clock.System.todayIn(TimeZone.currentSystemDefault())
           }

           UserEntity.new {
               password = "123456"
               birthDate = LocalDate(1999, 6, 13)
               name = "Christian Alexsander"
               email = "christian.alexsander@outlook.com"
           }
       }
    }

    override fun down() {
        MigrationEntity.find { MigrationTable.name eq className }
    }
}