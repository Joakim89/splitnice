package com.splitnice.domain

data class UserGroup(
    val id: Int = 0,
    val name: String,
    val description: String,
    val users: List<User>,
    val expenses: List<Expense>
) {
    fun calculateBalanceForUser(userId: Int): Float {
        val totalExpensesSum = getTotalSumOfExpenses()
        val amountPaidByUser = getSumOfExpensesPaidByUser(userId)
        val dividedTotalSum = totalExpensesSum / users.count().toFloat()

        return (dividedTotalSum - amountPaidByUser) * -1f
    }

    private fun getTotalSumOfExpenses(): Float {
        var sum = 0f
        for (expense in expenses) {
            sum += expense.amount
        }
        return sum
    }

    private fun getSumOfExpensesPaidByUser(userId: Int): Float {
        var sum = 0f
        for (expense in expenses) {
            if (expense.payerId == userId) {
                sum += expense.amount
            }
        }
        return sum
    }

}
