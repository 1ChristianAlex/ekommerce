package store.com.adapter.out.postgres.migrations

import kotlinx.datetime.LocalDate
import kotlinx.datetime.toJavaLocalDate
import org.ktorm.dsl.eq
import org.ktorm.dsl.insertAndGenerateKey
import org.ktorm.entity.removeIf
import org.ktorm.entity.sequenceOf
import store.com.adapter.out.postgres.model.UserEntity
import store.com.adapter.out.postgres.model.UserTable
import store.com.application.core.BaseDatabase

class InitialMigration(private val _database: BaseDatabase) : BaseMigration() {
    private val getUserTable get() = _database.database.sequenceOf(UserTable)

    override fun up() {

        val userEntity = UserEntity(
            password = "123456",
            birthDate = LocalDate(1999, 6, 13).toJavaLocalDate(),
            name = "Christian Alexsander",
            email = "christian.alexsander@outlook.com",
            id = 0
        )


        _database.database.insertAndGenerateKey(UserTable) {
            it.entityToTable(this, userEntity)
        }
    }

    override fun down() {
        getUserTable.removeIf { it.email eq "christian.alexsander@outlook.com" }
    }
}