package store.com.application.core

import org.ktorm.database.Database

interface BaseDatabase {
    val database: Database
}