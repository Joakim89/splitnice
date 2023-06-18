package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import java.sql.DriverManager

@Controller("/example")
class ExampleController {

    @Get(uri = "/", produces = ["text/plain"])
    fun index(): String {

        val jdbcUrl = "jdbc:mysql://localhost:3306/example"

        val connection = DriverManager
                .getConnection(jdbcUrl, "root", "1234")

        val query = connection.prepareStatement("SELECT * FROM somestuff")

        val result = query.executeQuery()

        result.next()

        val data = result.getString("data")

        return data.toString()
    }
}