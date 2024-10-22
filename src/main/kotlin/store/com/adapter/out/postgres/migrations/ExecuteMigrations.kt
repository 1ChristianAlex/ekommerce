package store.com.adapter.out.postgres.migrations

import io.ktor.server.application.*
import org.koin.ktor.ext.inject
import store.com.application.core.encrypt.PasswordEncrypt

class ExecuteMigrations(passwordEnCrypt: PasswordEncrypt) {
    private val migrationList = listOf(InitialMigration(passwordEnCrypt), AdminUserMigration(passwordEnCrypt))

    fun runUp() {
        migrationList.forEach {
            it.runUp()
        }
    }

    fun runDown() {
        migrationList.forEach {
            it.runDown()
        }
    }
}

fun Application.migration() {
    try {

        val passwordEnCrypt by inject<PasswordEncrypt>()

        ExecuteMigrations(passwordEnCrypt).runUp()
    } catch (e: Exception) {
        println("[ERROR] Error on database migrations - Message - ${e.message}")
    }
}