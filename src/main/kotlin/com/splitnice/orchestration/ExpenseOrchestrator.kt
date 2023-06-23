package com.splitnice.orchestration

import com.splitnice.controllers.ExpenseApiDto
import com.splitnice.domain.Expense
import com.splitnice.repositories.ExpenseRepo
import com.splitnice.repositories.UserGroupRepo
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ExpenseOrchestrator @Inject constructor(private val expenseRepo: ExpenseRepo, private val userGroupRepo: UserGroupRepo){
    fun createExpense(expenseApiDto: ExpenseApiDto) {
        val expense = Expense(
            amount = expenseApiDto.amount,
            note = expenseApiDto.note,
            payerId = expenseApiDto.payerId
            )
        expenseRepo.createExpense(expense, expenseApiDto.groupId)
    }

    fun getExpenseList(groupId: Int): List<Expense> {
        val userGroup = userGroupRepo.getUserGroup(groupId)

        return userGroup.expenses
    }
}
