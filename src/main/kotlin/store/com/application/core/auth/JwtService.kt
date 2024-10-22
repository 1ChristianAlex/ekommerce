package store.com.application.core.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.http.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import kotlinx.datetime.Clock
import kotlinx.datetime.toJavaInstant
import store.com.adapter.`in`.http.controller.user.dto.UserOutputDto
import store.com.application.core.SerializableError
import store.com.application.core.UseCaseResult
import kotlin.reflect.full.memberProperties

class JwtService {
    private val jwtAudience: String
        get() = System.getenv("JWT_AUDIENCE")
    private val jwtDomain: String
        get() = "http://localhost:6001"
    val jwtRealm: String
        get() = System.getenv("JWT_REALM")
    private val jwtSecret: String
        get() = System.getenv("JWT_SECRET")

    fun serverValidation(credential: JWTCredential): JWTPrincipal? =
        if (credential.payload.audience.contains(jwtAudience)) JWTPrincipal(credential.payload) else null

    fun registerJwt(): JWTVerifier = JWT
        .require(Algorithm.HMAC256(jwtSecret))
        .withAudience(jwtAudience).withIssuer(jwtDomain)
        .build()

    suspend fun challengeInvalidation(context: JWTChallengeContext, defaultScheme: String, realm: String): Unit {
        context.call.respond(
            HttpStatusCode.Unauthorized,
            UseCaseResult(false, null, SerializableError("Token is not valid or has expired"))
        )
    }

    fun generateToken(userOutputDto: UserOutputDto) {
        val token = JWT.create()
            .withAudience(jwtAudience)
            .withIssuer(jwtDomain)
            .apply {

                for (prop in UserOutputDto::class.memberProperties) {
                    println("${prop.name} = ${prop.get(userOutputDto)}")
                    withClaim(prop.name, "${prop.get(userOutputDto)}")
                }
                withClaim("id", userOutputDto.id)
            }
            .withExpiresAt(Clock.System.now().toJavaInstant().plusNanos(60000))
            .sign(Algorithm.HMAC256(jwtSecret))
    }
}