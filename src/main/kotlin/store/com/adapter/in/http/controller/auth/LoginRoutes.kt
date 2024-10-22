package store.com.adapter.`in`.http.controller.auth

import io.ktor.server.application.*
import io.ktor.server.routing.*
import kotlinx.coroutines.launch
import org.koin.ktor.ext.inject

fun Routing.loginController() {
    val controller by inject<LoginController>()

    route("auth") {
        post("login") {
            launch {
                controller.doLogin(call)
            }
        }
    }
}