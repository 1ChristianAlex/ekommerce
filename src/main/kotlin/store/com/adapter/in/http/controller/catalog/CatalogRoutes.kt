package store.com.adapter.`in`.http.controller.catalog

import io.ktor.server.application.*
import io.ktor.server.routing.*
import kotlinx.coroutines.launch
import org.koin.ktor.ext.inject

fun Routing.catalogRoutes() {
    val controller by inject<ProductController>()

    route("catalog") {
        get("product") {
            launch {
                controller.listProduct(call)
            }
        }
    }
}