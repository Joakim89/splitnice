package com.splitnice.orchestration

import com.splitnice.domain.User
import com.splitnice.repositories.UserRepo
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class UserOrchestrator @Inject constructor(private val userRepo: UserRepo) {
    fun getUser(email: String): User {
        val user = userRepo.getUser(email) //TODO: get user by email, instead of id

        return user
    }

    fun createUser(user: User) {
        userRepo.createUser(user)
    }
}