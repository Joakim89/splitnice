package com.splitnice.repositories

import com.splitnice.domain.Expense

interface ExpenseRepo {
    fun createExpense(expense: Expense, groupId: Int)
}