package com.splitnice.controllers

data class UserGroupApiDto(
    val id: Int = 0,
    val name: String,
    val description: String,
    val userIds: List<Int>
)