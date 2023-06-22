package com.splitnice.orchestration

import com.splitnice.controllers.UserGroupApiDto
import com.splitnice.domain.User
import com.splitnice.domain.UserGroup
import com.splitnice.repositories.UserGroupRepo
import com.splitnice.repositories.UserRepo
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class UserGroupOrchestrator @Inject constructor(private val userRepo: UserRepo, private val userGroupRepo: UserGroupRepo) {
    fun createUserGroup(userGroupApiDto: UserGroupApiDto){
        val users = getUsersByIds(userGroupApiDto.userIds)
        val userGroup = UserGroup(
            name = userGroupApiDto.name,
            description = userGroupApiDto.description,
            users = users,
            expenses = listOf()
        )

        userGroupRepo.createUserGroup(userGroup)
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