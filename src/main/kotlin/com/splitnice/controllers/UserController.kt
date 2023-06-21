package com.splitnice.controllers

import com.google.gson.Gson
import com.splitnice.domain.User
import com.splitnice.orchestration.UserOrchestrator
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import jakarta.inject.Inject

@Controller("/user")
class UserController @Inject constructor(private val userOrchestrator: UserOrchestrator){

    @Get(uri = "/{email}", produces = ["application/json"])
    fun getUser(@PathVariable email: String): String {

        val user = userOrchestrator.getUser(email)

        val gson = Gson()
        return gson.toJson(user)
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    fun createUser(@Body user: User){
        userOrchestrator.createUser(user)
    }
}