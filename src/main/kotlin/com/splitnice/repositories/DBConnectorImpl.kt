package com.splitnice.repositories

import io.micronaut.context.annotation.Value
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

@Singleton
class DBConnectorImpl @Inject constructor(
        @Value("\${datasources.default.url}") url: String,
        @Value("\${datasources.default.username}") username: String,
        @Value("\${datasources.default.password}") password: String) : DBConnector {

    private val connection: Connection

    init {
        connection = DriverManager.getConnection(url, username, password)
    }

    override fun getResultFromQuery(inputQuery: String): ResultSet {

        val query = connection.prepareStatement(inputQuery)

        val result = query.executeQuery()

        result.next()

        return result

    }

    override fun executeUpdateQuery(inputQuery: String): Int {
        val query = connection.prepareStatement(inputQuery, Statement.RETURN_GENERATED_KEYS)

        query.executeUpdate()

        val idQuery = connection.prepareStatement("SELECT LAST_INSERT_ID() AS id")

        val idResult = idQuery.executeQuery()
        idResult.next()
        val id = idResult.getInt("id")

        return id
    }
}