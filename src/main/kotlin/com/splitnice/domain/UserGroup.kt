package com.splitnice.domain

data class UserGroup(val name: String, val users: List<User>, val expenses: List<Expense>)
