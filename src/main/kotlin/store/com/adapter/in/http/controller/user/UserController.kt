package store.com.adapter.`in`.http.controller.user

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import store.com.adapter.`in`.http.controller.user.dto.UserInputDTO
import store.com.adapter.`in`.http.controller.user.dto.UserOutputDto
import store.com.application.core.BaseDtoMapper
import store.com.application.core.BaseUseCase
import store.com.application.core.UseCaseResult
import store.com.domain.user.model.UserModel

class UserController(
    private val createNewUserUseCase: BaseUseCase<UserModel, UserModel>,
    private val userDtoMapper: BaseDtoMapper<UserInputDTO, UserOutputDto, UserModel>
) {
    suspend fun createUser(call: ApplicationCall) {
        try {
            val loginRequest = call.receive<UserInputDTO>()

            val useCaseResult = createNewUserUseCase.execute(userDtoMapper.fromDto(loginRequest))

            useCaseResult.error?.let {
                call.response.status(HttpStatusCode.BadRequest)
            }

            val output = useCaseResult.run {
                UseCaseResult<UserOutputDto>(success, data?.let(userDtoMapper::toDto), error)
            }

            call.respond(output)
        } catch (e: Exception) {
            call.respond(HttpStatusCode.BadRequest, mapOf("message" to e.javaClass.simpleName))
        }
    }
}
