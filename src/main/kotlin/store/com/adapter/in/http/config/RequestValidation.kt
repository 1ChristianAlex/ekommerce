package store.com.adapter.`in`.http.config

import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*


fun Application.requestValidation() {
    install(RequestValidation) {}
}