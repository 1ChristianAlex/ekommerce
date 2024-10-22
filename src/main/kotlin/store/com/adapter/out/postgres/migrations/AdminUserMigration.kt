package store.com.adapter.out.postgres.migrations

import kotlinx.datetime.LocalDate
import org.jetbrains.exposed.sql.transactions.transaction
import store.com.adapter.out.postgres.model.UserEntity
import store.com.adapter.out.postgres.model.UserTable
import store.com.application.core.encrypt.PasswordEncrypt

class AdminUserMigration(private val _passwordEnCrypt: PasswordEncrypt) : BaseMigration() {
    override val time: Long
        get() = 1726601030555

    override fun up() {
        transaction {
            UserEntity.new {
                password = _passwordEnCrypt.hashPassword("123456")
                birthDate = LocalDate(1999, 6, 13)
                name = "Christian Alexsander"
                email = "christian.alexsander@outlook.com"
            }
        }
    }

    override fun down() {
        transaction {
            val adminUser = UserEntity.find { UserTable.email eq "christian.alexsander@outlook.com" }
            adminUser.firstOrNull()?.delete()
        }
    }
}