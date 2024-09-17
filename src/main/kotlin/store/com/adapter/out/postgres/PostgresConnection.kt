package store.com.adapter.out.postgres

import org.ktorm.database.Database
import store.com.application.core.BaseDatabase

class PostgresConnection : BaseDatabase {
    init {
        createConnection()
    }


    private lateinit var _database: Database

    override val database get() = _database

    private fun createConnection() {
        try {
            // Todo: Change database library to https://jetbrains.github.io/Exposed/home.html
            val postgresDb = System.getenv("POSTGRES_DB")
            val postgresPort = System.getenv("POSTGRES_PORT")
            val postgresUser = System.getenv("POSTGRES_USER")
            val postgresPassword = System.getenv("POSTGRES_PASSWORD")
            val databaseUrl = System.getenv("DB_URL")
            this._database = Database.connect(
                url = "jdbc:postgresql://$databaseUrl:$postgresPort/$postgresDb",
                driver = "org.postgresql.Driver",
                user = postgresUser,
                password = postgresPassword
            )
        }
        catch (e:Exception){
            println("[ERROR] Error on database connection - Message - ${e.message}")
        }
    }
}