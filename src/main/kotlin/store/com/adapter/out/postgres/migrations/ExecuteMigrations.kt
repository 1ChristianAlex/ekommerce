package store.com.adapter.out.postgres.migrations

import io.ktor.server.application.*
import org.koin.ktor.ext.inject
import store.com.application.core.BaseDatabase

class ExecuteMigrations(private val _database: BaseDatabase) {

    private val migrationList = listOf(InitialMigration(_database))

    fun runUp() {
        migrationList.forEach {
            it.up()
        }
    }

    fun runDown() {
        migrationList.forEach {
            it.down()
        }
    }
}

fun Application.migration() {
    val database by inject<BaseDatabase>()
    try {
        ExecuteMigrations(database).runUp()
    } catch (e: Exception) {
        println("[ERROR] Error on database migrations - Message - ${e.message}")
    }
}