package com.splitnice.orchestration

import com.splitnice.domain.User
import com.splitnice.repositories.UserRepo
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class UserOrchestrator @Inject constructor(private val userRepo: UserRepo) {
    fun getUser(id: Int): User {
        val user = userRepo.getUser(id)

        return user

    }
}