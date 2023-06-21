package com.splitnice.repositories

import com.splitnice.domain.User
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class UserRepoImpl @Inject constructor(private val dbConnector: DBConnector) : UserRepo {
    override fun getUserByEmail(email: String): User {
        val inputQuery = "SELECT id, name, email FROM users WHERE email = ${email};"

        val result = dbConnector.getResultFromQuery(inputQuery)

        val id = result.getInt("id")
        val name = result.getString("name")
        val emailFromDb = result.getString("email")

        return User(id, name, emailFromDb)
    }

    override fun createUser(user: User) {
        val inputQuery = "INSERT INTO splitnice.users (name, email)\n" +
                "VALUES ('${user.name}', '${user.email}');"

        dbConnector.executeUpdateQuery(inputQuery)
    }
}
