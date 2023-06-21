package com.splitnice.repositories

import com.splitnice.domain.User

interface UserRepo {
    fun getUser(email: String): User

    fun createUser(user: User)
}