package store.com.application.core

import org.jetbrains.exposed.sql.Database


interface BaseDatabase {
    val database: Database
}