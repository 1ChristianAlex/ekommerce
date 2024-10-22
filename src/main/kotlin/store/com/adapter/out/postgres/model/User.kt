package store.com.adapter.out.postgres.model


import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.kotlin.datetime.date


object UserTable : BaseTable("user.user") {
    val name = text("name")
    val email = text("email")
    val password = text("password")
    val birthDate = date("birthDate")
}

class UserEntity(id: EntityID<Int>) : BaseEntity(id) {
    companion object Factory : IntEntityClass<UserEntity>(UserTable)

    var name by UserTable.name
    var email by UserTable.email
    var birthDate by UserTable.birthDate
    var password by UserTable.password
    override var createdAt by UserTable.createdAt
    override var updatedAt by UserTable.updatedAt
}