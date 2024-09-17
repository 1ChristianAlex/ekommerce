package store.com.adapter.out.postgres.migrations

import io.ktor.server.application.*

class ExecuteMigrations() {

    private val migrationList = listOf(InitialMigration())

    fun runUp() {
        migrationList.forEach {
            it::up.invoke()
        }
    }

    fun runDown() {
        migrationList.forEach {
            it.down()
        }
    }
}

fun Application.migration() {
    try {
        ExecuteMigrations().runUp()
    } catch (e: Exception) {
        println("[ERROR] Error on database migrations - Message - ${e.message}")
    }
}