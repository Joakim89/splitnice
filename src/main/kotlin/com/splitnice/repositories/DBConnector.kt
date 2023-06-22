package com.splitnice.repositories

import java.sql.ResultSet

interface DBConnector {
    fun getResultFromQuery(inputQuery: String): ResultSet

    fun executeUpdateQuery(inputQuery: String): Int
}