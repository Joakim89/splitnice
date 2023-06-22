package com.splitnice.controllers

import com.splitnice.orchestration.ExpenseOrchestrator
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller("/expense")
class ExpenseController @Inject constructor(private val expenseOrchestrator: ExpenseOrchestrator){

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    fun createUserGroup(@Body expenseApiDto: ExpenseApiDto){
        expenseOrchestrator.createExpense(expenseApiDto)
    }
}