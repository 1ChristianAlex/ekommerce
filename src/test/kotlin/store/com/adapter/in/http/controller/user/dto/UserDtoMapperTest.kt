package store.com.adapter.`in`.http.controller.user.dto

import com.google.gson.Gson
import kotlinx.datetime.LocalDate
import store.com.domain.user.model.UserModel
import kotlin.test.Test
import kotlin.test.assertIs


class UserDtoMapperTest {

    @Test
    fun `should parse from input dto`() {

        val body = Gson().fromJson(
            "{\n" +
                    "    \"id\": 521,\n" +
                    "    \"name\": \"David Miller\",\n" +
                    "    \"email\": \"David.Miller@example.com\",\n" +
                    "    \"password\": \"fake_password\",\n" +
                    "    \"birthDate\": \"2024-07-18T16:08:19.587Z\"\n" +
                    "}", UserInputDTO::class.java
        )

        val mapper = UserDtoMapper()

        val mapped = mapper.fromDto(body)

        assertIs<UserModel>(mapped)
    }

    @Test
    fun `should parse to input dto`() {

        val body = UserModel("Christian Santos", "christian.alexsander@outlook.com", LocalDate(1999, 6, 13), 56)

        val mapper = UserDtoMapper()

        val mapped = mapper.toDto(body)

        assertIs<UserOutputDto>(mapped)
    }
}