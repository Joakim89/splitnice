package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import java.sql.DriverManager

data class SomeStuff(val id: Int, val data: Int)

@Controller("/example")
class ExampleController {

    @Get(uri = "/", produces = ["text/plain"])
    fun index(): String {

        val jdbcUrl = "jdbc:mysql://localhost:3306/example"

        val connection = DriverManager
                .getConnection(jdbcUrl, "root", "1234")

        print(connection.isValid(0))

        val query = connection.prepareStatement("SELECT * FROM somestuff")

        val result = query.executeQuery()

        result.next()

        val id = result.getInt("id")
        val data = result.getString("data")

        return data.toString()
    }
}