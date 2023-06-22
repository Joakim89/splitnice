package com.splitnice.controllers

import com.google.gson.Gson
import com.splitnice.orchestration.ExpenseOrchestrator
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import jakarta.inject.Inject

@Controller("/expense")
class ExpenseController @Inject constructor(private val expenseOrchestrator: ExpenseOrchestrator){

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    fun createUserGroup(@Body expenseApiDto: ExpenseApiDto){
        expenseOrchestrator.createExpense(expenseApiDto)
    }

    @Get(uri = "expenselist/{groupId}", produces = ["application/json"])
    fun getExpenseList(@PathVariable groupId: Int): String {

        val expenseList = expenseOrchestrator.getExpenseList(groupId)

        val gson = Gson()
        return gson.toJson(expenseList)
    }
}