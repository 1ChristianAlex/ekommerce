package store.com.application.core

import kotlinx.datetime.*

interface BaseRepositoryMapper<TInput, TOutput> {
    fun toModel(input: TInput): TOutput
    fun fromModel(output: TOutput): TInput
}

abstract class BaseDtoMapper<TDtoInput, TDtoOutput, TOutput> {
    abstract fun toDto(output: TOutput): TDtoOutput
    abstract fun fromDto(input: TDtoInput): TOutput

    protected fun toUTCString(date: LocalDateTime): String {
        return date.toInstant(TimeZone.UTC).toString()
    }

    protected fun fromIsoString(date: String): LocalDateTime {
        return Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault())
    }
}