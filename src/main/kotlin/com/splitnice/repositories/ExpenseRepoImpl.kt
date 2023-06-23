package com.splitnice.repositories

import com.splitnice.domain.Expense
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.sql.ResultSet

@Singleton
class ExpenseRepoImpl @Inject constructor(private val dbConnector: DBConnector) : ExpenseRepo {
    override fun createExpense(expense: Expense, groupId: Int) {
        val inputQuery = "INSERT INTO splitnice.expenses (amount, payer, note, `group`)\n" +
                         "VALUES (${expense.amount}, ${expense.payerId}, '${expense.note}', ${groupId});"

        dbConnector.executeUpdateQuery(inputQuery)
    }

    override fun getExpensesByGroup(groupId: Int): List<Expense> {
        val inputQuery = "SELECT *\n" +
                "FROM splitnice.expenses\n" +
                "WHERE `group`=${groupId};"

        val result = dbConnector.getResultFromQuery(inputQuery)

        val expenses = mutableListOf<Expense>()
        expenses.add(getExpenseFromResult(result))

        while (result.next()) {
            expenses.add(getExpenseFromResult(result))
        }

        return expenses

    }

    private fun getExpenseFromResult(result: ResultSet): Expense {
        val id = result.getInt("id")
        val amount = result.getFloat("amount")
        val payerId = result.getInt("payer")
        val note = result.getString("note")

        return Expense(id, amount, note, payerId)
    }

}

