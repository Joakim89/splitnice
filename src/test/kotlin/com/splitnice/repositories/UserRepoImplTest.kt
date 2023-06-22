package com.splitnice.repositories

import com.splitnice.domain.Expense
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class ExpenseRepoImplTest {

    @Mock
    private lateinit var dbConnector: DBConnector

    private lateinit var expenseRepo: ExpenseRepo

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
        expenseRepo = ExpenseRepoImpl(dbConnector)
    }

    @Test
    fun createExpenseTest() {  //TODO: Test not fully implemented
        val expense = Expense(amount = 100.0f, payerId = 1, note = "Test Expense")
        val groupId = 1

        val inputQuery = "INSERT INTO splitnice.expenses (amount, payer, note, `group`)\n" +
                "VALUES (${expense.amount}, ${expense.payerId}, '${expense.note}', $groupId);"
        `when`(dbConnector.executeUpdateQuery(inputQuery)).thenReturn(1)

        expenseRepo.createExpense(expense, groupId)

        assertEquals(1, dbConnector.executeUpdateQuery(inputQuery))
    }
}