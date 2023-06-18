package com.splitnice.controllers

import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@MicronautTest
class ExampleControllerTest {

    @Inject
    @field:Client("/example")
    lateinit var httpClient: HttpClient

    @Test
    fun testIndex() {
        val response = httpClient.toBlocking().exchange("/", String::class.java)

        assertEquals(HttpStatus.OK, response.status)
        assertEquals("22", response.body())
    }
}