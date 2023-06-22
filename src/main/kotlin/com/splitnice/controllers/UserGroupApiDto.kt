package com.splitnice.controllers

data class UserGroupApiDto(
    val name: String,
    val description: String,
    val userIds: List<Int>
)