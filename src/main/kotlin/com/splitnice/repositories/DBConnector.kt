package com.splitnice.repositories

import io.micronaut.context.annotation.Value
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

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

        result.next()  //TODO: handle case when null, throw exception or wrap in option

        return result

    }

    fun executeUpdateQuery(inputQuery: String): ResultSet {
        val query = connection.prepareStatement(inputQuery, Statement.RETURN_GENERATED_KEYS)

        query.executeUpdate()

        val generatedKeys = query.generatedKeys

        generatedKeys.next()  //TODO: handle case when null, throw exception or wrap in option

        return generatedKeys
    }
}