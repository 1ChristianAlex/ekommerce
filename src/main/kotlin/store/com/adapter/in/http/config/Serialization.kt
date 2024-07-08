package store.com.adapter.`in`.http.config

import io.ktor.serialization.gson.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import java.text.DateFormat

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
        gson {
            serializeNulls().setDateFormat(DateFormat.LONG, DateFormat.LONG).setPrettyPrinting()
        }
    }

}
