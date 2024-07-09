package store.com

import io.ktor.server.application.*
import store.com.adapter.`in`.di.configDI
import store.com.adapter.`in`.http.config.configureHTTP
import store.com.adapter.`in`.http.config.configureSecurity
import store.com.adapter.`in`.http.config.configureSerialization
import store.com.adapter.`in`.http.config.requestValidation
import store.com.adapter.`in`.http.controller.appRoutes

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configDI()
    configureSerialization()
//    configureDatabases()
    configureHTTP()
    configureSecurity()
    requestValidation()
    appRoutes()
}
