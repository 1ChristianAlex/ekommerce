package store.com.adapter.`in`.http.controller

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.helloController() {
    authenticate("auth-jwt") {
        route("/") {
            get("/hello") {
                call.respond(mapOf("hello" to "world"))
            }
        }
    }
}