package com.splitnice.repositories

import com.splitnice.domain.User

interface UserRepo {
    fun getUserByEmail(email: String): User

    fun createUser(user: User)
}