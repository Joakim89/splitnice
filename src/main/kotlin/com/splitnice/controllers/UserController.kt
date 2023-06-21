package com.splitnice.controllers

import com.google.gson.Gson
import com.splitnice.domain.User
import com.splitnice.orchestration.UserOrchestrator
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import jakarta.inject.Inject

@Controller("/user")
class UserController @Inject constructor(private val userOrchestrator: UserOrchestrator){

    @Get(uri = "/{id}", produces = ["application/json"])
    fun getUser(@PathVariable id: Int): String {

        val user = userOrchestrator.getUser(id)

        val gson = Gson()
        return gson.toJson(user)
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    fun createUser(@Body user: User){
        userOrchestrator.createUser(user)
    }
}