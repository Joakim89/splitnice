package com.splitnice.domain

data class UserGroup(val id: Int = 0, val name: String?, val users: List<User>?, val expenses: List<Expense>)
