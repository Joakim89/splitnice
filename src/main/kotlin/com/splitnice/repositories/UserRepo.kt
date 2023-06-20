package com.splitnice.repositories

import com.splitnice.domain.User

interface UserRepo {
    fun getUser(userId: Int): User
}