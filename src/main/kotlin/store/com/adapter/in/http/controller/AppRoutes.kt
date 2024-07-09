package store.com.adapter.`in`.http.controller

import io.ktor.server.application.*
import io.ktor.server.routing.*
import store.com.adapter.`in`.http.controller.auth.loginController

fun Application.appRoutes() {
    routing {
        helloController()
        loginController()
    }
}