package store.com.application.core

interface BaseRepositoryMapper<TInput, TOutput> {
    fun toModel(input: TInput): TOutput
    fun fromModel(output: TOutput): TInput
}

interface BaseControllerMapper<TInput, TOutput> {
    fun toDto(input: TInput): TOutput
    fun fromDto(output: TOutput): TInput
}