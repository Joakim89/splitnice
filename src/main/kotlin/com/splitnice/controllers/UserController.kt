package com.splitnice.controllers

import com.google.gson.Gson
import com.splitnice.orchestration.UserOrchestrator
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import jakarta.inject.Inject

@Controller("/user")
class UserController @Inject constructor(private val userOrchestrator: UserOrchestrator){

    @Get(uri = "/{id}", produces = ["application/json"])
    fun getUser(@PathVariable id: Int): String {

        val user = userOrchestrator.getUser(id)

        val gson = Gson()
        return gson.toJson(user)
    }
}