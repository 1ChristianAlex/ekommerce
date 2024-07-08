package store.com.adapter.`in`.http.controller

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.helloController(){
    routing {
        get("/hello") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}