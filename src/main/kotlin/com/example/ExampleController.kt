package com.example

import io.micronaut.context.annotation.Value
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject
import java.sql.Connection

import java.sql.DriverManager

@Controller("/example")
class ExampleController @Inject constructor(
        @Value("\${datasources.default.url}") url: String,
        @Value("\${datasources.default.username}") username: String,
        @Value("\${datasources.default.password}") password: String) {

    private val connection: Connection

    init {
        connection = DriverManager.getConnection(url, username, password)
    }

    @Get(uri = "/", produces = ["text/plain"])
    fun index(): String {

        val query = connection.prepareStatement("SELECT * FROM somestuff")

        val result = query.executeQuery()

        result.next()

        val data = result.getString("data")

        return data.toString()
    }
}