package com.splitnice.orchestration

import com.splitnice.controllers.UserGroupApiDto
import com.splitnice.domain.Expense
import com.splitnice.domain.User
import com.splitnice.domain.UserGroup
import com.splitnice.repositories.UserRepo
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class UserGroupOrchestrator @Inject constructor(private val userRepo: UserRepo) {
    fun createUserGroup(userGroupApiDto: UserGroupApiDto){
        val users = getUsersByIds(userGroupApiDto.userIds)
        val userGroup = UserGroup(name = userGroupApiDto.name, users = users, expenses = listOf())
        //TODO: create repo method to create a user group from a domain object
    }

    private fun getUsersByIds(ids: List<Int>): List<User> {
        val users = mutableListOf<User>()

        for (id in ids) {
            val user = userRepo.getUser(id)
            users.add(user)
        }

        return users
    }
}