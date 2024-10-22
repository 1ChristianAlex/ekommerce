package store.com.application.core.encrypt

import org.mindrot.jbcrypt.BCrypt

class PasswordEncrypt {
    fun hashPassword(password: String): String {
        val salt = BCrypt.gensalt()
        return BCrypt.hashpw(password, salt)
    }

    fun checkPassword(hashedPassword: String, password: String): Boolean {
        return BCrypt.checkpw(password, hashedPassword)
    }
}