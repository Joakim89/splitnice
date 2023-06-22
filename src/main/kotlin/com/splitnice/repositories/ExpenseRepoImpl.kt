package com.splitnice.repositories

import com.splitnice.domain.Expense
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ExpenseRepoImpl @Inject constructor(private val dbConnector: DBConnector) : ExpenseRepo {
    override fun createExpense(expense: Expense, groupId: Int) {
        val inputQuery = "INSERT INTO splitnice.expenses (amount, payer, note, `group`)\n" +
                         "VALUES (${expense.amount}, ${expense.payerId}, '${expense.note}', ${groupId});"

        dbConnector.executeUpdateQuery(inputQuery)
    }
}

