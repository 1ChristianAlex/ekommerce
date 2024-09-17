package store.com.adapter.`in`.http.controller.user

import io.ktor.server.application.*
import io.ktor.server.routing.*
import kotlinx.coroutines.launch
import org.koin.ktor.ext.inject

fun Routing.userController() {
    val controller by inject<UserController>()

    route("user") {
        post("create") {
            launch {
                controller.createUser(call)
            }
        }
    }
}