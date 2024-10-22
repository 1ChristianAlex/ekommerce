package store.com.adapter.out.postgres.migrations

import kotlinx.datetime.Instant
import org.jetbrains.exposed.sql.Schema
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.transactions.transaction
import store.com.adapter.out.postgres.model.MigrationEntity
import store.com.adapter.out.postgres.model.MigrationTable

abstract class BaseMigration {
    abstract val time: Long
    protected abstract fun up()
    protected abstract fun down(): Unit
    private val dateTimeMigration get() = Instant.fromEpochMilliseconds(time)
    private var migrationAlreadyRun = false

    val className get() = javaClass.kotlin.simpleName.orEmpty()


    private fun checkMigration() {

        val result = getCurrentMigration()

        migrationAlreadyRun = result != null
    }

    private fun getCurrentMigration(): MigrationEntity? {
        transaction {
            SchemaUtils.createSchema(
                Schema("migrations")
            )
            SchemaUtils.create(MigrationTable)

            println("Running schemas")
        }

        return transaction {
            val result =
                MigrationEntity.find { (MigrationTable.time eq dateTimeMigration) and (MigrationTable.name eq className) }

            result.firstOrNull()
        }
    }

    fun runUp() {
        checkMigration()

        if (!migrationAlreadyRun) {

            up()

            transaction {
                MigrationEntity.new {
                    name = className
                    time = dateTimeMigration
                }
            }

        }
    }

    fun runDown() {
        checkMigration()

        if (migrationAlreadyRun) {
            down()

            transaction {
                val toDelete = MigrationEntity.find {
                    (MigrationTable.name eq className) and (MigrationTable.time eq dateTimeMigration)
                }
                toDelete.first().delete()

            }
        }
    }
}