package com.splitnice.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculateBalanceTest {

    private lateinit var users: List<User>
    private val tolerance = 0.000001f

    @BeforeEach
    fun setup() {
        // Given
        val user1 = User(1, "James", "")
        val user2 = User(2, "Jane", "")

        users = listOf(user1, user2)
    }

    @Test
    fun whenAllPayEqualAmountThenBalanceIsZero() {
        // Given
        val expense1 = Expense(1, 100f, "", 1)
        val expense2 = Expense(2, 100f, "", 2)

        val expenses = listOf(expense1, expense2)

        val userGroup = UserGroup(1, "J group", "", users, expenses)

        // When
        val balance = userGroup.calculateBalanceForUser(1)

        // Then
        val expectedBalance = 0f
        Assertions.assertEquals(balance, expectedBalance, tolerance)

    }

    @Test
    fun whenUserPaysLessThenBalanceIsNegative() {
        // Given
        val expense1 = Expense(1, 100f, "", 1)
        val expense2 = Expense(2, 100f, "", 2)
        val expense3 = Expense(2, 50f, "", 2)

        val expenses = listOf(expense1, expense2, expense3)

        val userGroup = UserGroup(1, "J group", "", users, expenses)

        // When
        val balance = userGroup.calculateBalanceForUser(1)

        // Then
        val expectedBalance = -25f
        Assertions.assertEquals(balance, expectedBalance, tolerance)

    }

    @Test
    fun whenUserPaysMoreThenBalanceIsPositive() {
        // Given
        val expense1 = Expense(1, 100f, "", 1)
        val expense2 = Expense(2, 100f, "", 2)
        val expense3 = Expense(2, 50f, "", 2)

        val expenses = listOf(expense1, expense2, expense3)

        val userGroup = UserGroup(1, "J group", "", users, expenses)

        // When
        val balance = userGroup.calculateBalanceForUser(2)

        // Then
        val expectedBalance = 25f
        Assertions.assertEquals(balance, expectedBalance, tolerance)

    }
}