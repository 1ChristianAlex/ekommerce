package store.com

import io.ktor.server.application.*
import store.com.adapter.`in`.di.configDI
import store.com.adapter.`in`.http.config.configureHTTP
import store.com.adapter.`in`.http.config.configureSecurity
import store.com.adapter.`in`.http.config.configureSerialization
import store.com.adapter.`in`.http.config.requestValidation
import store.com.adapter.`in`.http.controller.appRoutes
import store.com.adapter.out.postgres.dbConnection
import store.com.adapter.out.postgres.migrations.migration

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    dbConnection()
    configDI()
    migration()
    configureSerialization()
    configureHTTP()
    configureSecurity()
    requestValidation()
    appRoutes()
}
