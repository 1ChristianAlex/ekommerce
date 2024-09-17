package store.com.adapter.out.postgres.model


import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.date


object UserTable : IntIdTable("user.user") {
    val name = text("name")
    val email = text("email")
    val password = text("password")
    val birthDate = date("birthDate")
}

class UserEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object Factory: IntEntityClass<UserEntity>(UserTable)
    var name by UserTable.name
    var email by UserTable.email
    var birthDate by UserTable.birthDate
    var password by UserTable.password
}