package store.com.adapter.out.postgres.migrations

import kotlinx.datetime.Clock

abstract class BaseMigration {
    val time = Clock.System.now()
    abstract fun up(): Unit
    abstract fun down(): Unit
    val className get() = javaClass.kotlin.simpleName.orEmpty()
}