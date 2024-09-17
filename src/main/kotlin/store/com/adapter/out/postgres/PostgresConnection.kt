package store.com.adapter.out.postgres

import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

class PostgresConnection {
    fun createConnection() {
        try {
            // Todo: Change database library to https://jetbrains.github.io/Exposed/home.html
            val postgresDb = System.getenv("POSTGRES_DB")
            val postgresPort = System.getenv("POSTGRES_PORT")
            val postgresUser = System.getenv("POSTGRES_USER")
            val postgresPassword = System.getenv("POSTGRES_PASSWORD")
            val databaseUrl = System.getenv("DB_URL")
            Database.connect(
                url = "jdbc:postgresql://$databaseUrl:$postgresPort/$postgresDb",
                driver = "org.postgresql.Driver",
                user = postgresUser,
                password = postgresPassword
            )
        } catch (e: Exception) {
            println("[ERROR] Error on database connection - Message - ${e.message}")
        }
    }
}

fun Application.dbConnection() {
    try {
        PostgresConnection().createConnection()
    } catch (e: Exception) {
        println("[ERROR] Error connection database - Message - ${e.message}")
    }
}
