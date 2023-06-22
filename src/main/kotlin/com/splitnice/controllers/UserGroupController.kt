package com.splitnice.controllers

import com.splitnice.orchestration.UserGroupOrchestrator
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import jakarta.inject.Inject

@Controller("/usergroup")
class UserGroupController @Inject constructor(private val userGroupOrchestrator: UserGroupOrchestrator){

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    fun createUserGroup(@Body userGroupApiDto: UserGroupApiDto){
        userGroupOrchestrator.createUserGroup(userGroupApiDto)
    }
}