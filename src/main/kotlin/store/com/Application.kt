package store.com

import io.ktor.server.application.*
import store.com.adapter.`in`.di.configDI
import store.com.adapter.`in`.http.config.configureHTTP
import store.com.adapter.`in`.http.config.configureSecurity
import store.com.adapter.`in`.http.controller.helloController
import store.com.plugins.configureDatabases
import store.com.adapter.`in`.http.config.configureSerialization

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configDI()
    configureSerialization()
    configureDatabases()
    configureHTTP()
    configureSecurity()
    helloController()
}
