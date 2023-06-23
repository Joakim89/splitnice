package com.splitnice.domain

data class UserGroup(
    val id: Int = 0,
    val name: String,
    val description: String,
    val users: List<User>,
    val expenses: List<Expense>
) {
    fun calculateBalanceForUser(userId: Int): Float {
        TODO("not yet implemented")
    }

}
