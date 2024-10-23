package store.com.adapter.`in`.http.controller

import io.ktor.server.application.*
import io.ktor.server.routing.*
import store.com.adapter.`in`.http.controller.auth.loginRoutes
import store.com.adapter.`in`.http.controller.catalog.catalogRoutes
import store.com.adapter.`in`.http.controller.user.userRoutes

fun Application.appRoutes() {
    routing {
        loginRoutes()
        userRoutes()
        catalogRoutes()
    }
}