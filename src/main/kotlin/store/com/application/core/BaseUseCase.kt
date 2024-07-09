package store.com.application.core

import com.google.gson.Gson
import kotlinx.serialization.Serializable

@Serializable
data class SerializableError(val message: String)

@Serializable
data class UseCaseResult<TOutput>(val success: Boolean = false, val data: TOutput?, val error: SerializableError?)

abstract class BaseUseCase<TInput, TOutput> {
    protected abstract suspend fun internalExecute(inputData: TInput): TOutput
    protected abstract fun useCaseDescription(): String

    suspend fun execute(inputData: TInput): UseCaseResult<TOutput> {
        try {
            val result = internalExecute(inputData)

            return UseCaseResult(success = true, data = result, error = null)
        } catch (e: Exception) {
            val inputJson = Gson().toJson(inputData)
            val message = "Error executing use case: ${useCaseDescription()} - inputData: $inputJson - $e.message"
            return UseCaseResult(success = false, data = null, error = SerializableError(message))
        }
    }
}