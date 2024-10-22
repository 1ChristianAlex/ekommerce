package store.com.adapter.`in`.http.controller.auth

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import store.com.adapter.`in`.http.controller.auth.dto.LoginInputDTO
import store.com.application.user.port.DoLoginUserEmailUseCase

class LoginController(private val doLoginUseCase: DoLoginUserEmailUseCase) {
    suspend fun doLogin(call: ApplicationCall) {
        try {
            val loginRequest = call.receive<LoginInputDTO>()

            val useCaseResult = doLoginUseCase.execute(loginRequest)

            useCaseResult.error?.let {
                call.response.status(HttpStatusCode.BadRequest)
            }

            call.respond(useCaseResult)
        } catch (e: Exception) {
            call.respond(HttpStatusCode.BadRequest, mapOf("message" to e.javaClass.simpleName))
        }
    }
}

