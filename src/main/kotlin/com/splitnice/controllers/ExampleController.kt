package com.splitnice.controllers

import com.splitnice.repositories.DBConnector
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject

@Controller("/example")
class ExampleController @Inject constructor(private val dbConnector: DBConnector){

    @Get(uri = "/", produces = ["text/plain"])
    fun index(): String {

        val inputQuery = "SELECT * FROM somestuff"

        val result = dbConnector.getResultFromQuery(inputQuery)

        val data = result.getString("data")

        return data.toString()
    }
}