package store.com.adapter.`in`.http.controller

import io.ktor.server.application.*
import io.ktor.server.routing.*
import store.com.adapter.`in`.http.controller.auth.loginController
import store.com.adapter.`in`.http.controller.user.userController

fun Application.appRoutes() {
    routing {
        loginController()
        userController()
    }
}