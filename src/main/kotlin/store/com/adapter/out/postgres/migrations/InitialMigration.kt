package store.com.adapter.out.postgres.migrations

import kotlinx.datetime.LocalDate
import org.jetbrains.exposed.sql.Schema
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import store.com.adapter.out.postgres.model.MigrationEntity
import store.com.adapter.out.postgres.model.MigrationTable
import store.com.adapter.out.postgres.model.UserEntity
import store.com.adapter.out.postgres.model.UserTable
import store.com.application.core.encrypt.PasswordEncrypt

class InitialMigration(private val _passwordEnCrypt: PasswordEncrypt) : BaseMigration() {
    override val time: Long
        get() = 1726596478674

    override fun up() {

        transaction {
            SchemaUtils.createSchema(Schema("user"))
            SchemaUtils.create(UserTable)

            UserEntity.new {
                password = _passwordEnCrypt.hashPassword("123456")
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