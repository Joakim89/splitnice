package com.splitnice.domain

data class Expense(
    val id: Int = 0,
    val amount: Float,
    val description: String,
    val payer: User
)