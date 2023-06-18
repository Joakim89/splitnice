package com.splitnice.repositories

import io.micronaut.context.annotation.Value
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet

@Singleton
class DBConnector @Inject constructor(
        @Value("\${datasources.default.url}") url: String,
        @Value("\${datasources.default.username}") username: String,
        @Value("\${datasources.default.password}") password: String) {

    private val connection: Connection

    init {
        connection = DriverManager.getConnection(url, username, password)
    }


    fun getResultFromQuery(inputQuery: String): ResultSet {

        val query = connection.prepareStatement(inputQuery)

        val result = query.executeQuery()

        result.next()

        return result

    }
}