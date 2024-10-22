package store.com.adapter.`in`.http.config

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import org.koin.ktor.ext.inject
import store.com.application.core.auth.JwtService

fun Application.configureSecurity() {

    val jwtService by inject<JwtService>()
    install(Authentication) {

        jwt("auth-jwt") {
            realm = jwtService.jwtRealm
            verifier(
                jwtService.registerJwt()
            )
            validate {
                jwtService.serverValidation(it)
            }
            challenge { defaultScheme, realm ->
                jwtService.challengeInvalidation(this, defaultScheme, realm)
            }
        }
    }
}
