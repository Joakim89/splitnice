package com.splitnice.controllers

import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@MicronautTest
class UserControllerTest {

    @Inject
    @field:Client("/user")
    lateinit var httpClient: HttpClient

    @Test
    fun testGet() {
        val response = httpClient.toBlocking().exchange("/1", String::class.java)

        assertEquals(HttpStatus.OK, response.status)
        assertEquals("{\"id\":1,\"name\":\"John\",\"email\":\"john@mail.com\"}", response.body())
    }
}