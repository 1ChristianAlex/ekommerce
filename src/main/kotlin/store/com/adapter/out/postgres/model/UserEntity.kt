package store.com.adapter.out.postgres.model

import org.ktorm.dsl.AssignmentsBuilder
import org.ktorm.dsl.QueryRowSet
import org.ktorm.schema.BaseTable
import org.ktorm.schema.date
import org.ktorm.schema.int
import org.ktorm.schema.varchar
import java.time.LocalDate

data class UserEntity(
    val id: Int,
    val name: String,
    val email: String,
    val password: String?,
    val birthDate: LocalDate,
)


object UserTable : BaseTable<UserEntity>("user", "usr", null, "user") {
    val id = int("id").primaryKey()
    val name = varchar("name")
    val email = varchar("email")
    val password = varchar("password")
    val birthDate = date("birthDate")

    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean) = UserEntity(
        id = row[id] ?: 0,
        name = row[name].orEmpty(),
        email = row[email].orEmpty(),
        birthDate = row[birthDate] ?: LocalDate.now(),
        password = row[password].orEmpty()
    )

    fun entityToTable(builder: AssignmentsBuilder, entity: UserEntity){
        builder.set(this.name, entity.name)
        builder.set(this.email, entity.email)
        builder.set(this.password, entity.password)
        builder.set(this.birthDate, entity.birthDate)
    }
}