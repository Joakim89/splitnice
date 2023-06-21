package com.splitnice.repositories

import com.splitnice.domain.User
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class UserRepoImpl @Inject constructor(private val dbConnector: DBConnector) : UserRepo {
    override fun getUser(userId: Int): User {
        val inputQuery = "SELECT id, name, email FROM users WHERE id = ${userId};"

        val result = dbConnector.getResultFromQuery(inputQuery)

        val id = result.getInt("id")
        val name = result.getString("name")
        val email = result.getString("email")

        return User(id, name, email)
    }

    override fun createUser(user: User) {
        val inputQuery = "INSERT INTO splitnice.users (name, email)\n" +
                "VALUES ('${user.name}', '${user.email}');"

        dbConnector.executeUpdateQuery(inputQuery)
    }
}
