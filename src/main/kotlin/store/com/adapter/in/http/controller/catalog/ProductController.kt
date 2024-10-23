package store.com.adapter.`in`.http.controller.catalog

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import store.com.application.catalog.port.usecase.GetProductListUseCase

class ProductController(
    private val getProductListUseCase: GetProductListUseCase
) {
    suspend fun listProduct(call: ApplicationCall) {
        try {

            val useCaseResult = getProductListUseCase.execute(Unit)

            useCaseResult.error?.let {
                call.response.status(HttpStatusCode.BadRequest)
            }

            call.respond(useCaseResult)
        } catch (e: Exception) {
            call.respond(HttpStatusCode.BadRequest, mapOf("message" to e.javaClass.simpleName))
        }
    }
}
