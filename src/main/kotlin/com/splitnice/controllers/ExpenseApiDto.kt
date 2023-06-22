package com.splitnice.controllers

data class ExpenseApiDto(
    val id: Int = 0,
    val amount: Float,
    val note: String,
    val payerId: Int,
    val groupId: Int
)