package com.splitnice.repositories

import com.splitnice.domain.UserGroup
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class UserGroupRepoImpl @Inject constructor(private val dbConnector: DBConnector) : UserGroupRepo {
    override fun createUserGroup(userGroup: UserGroup) {
        val inputQuery = "INSERT INTO splitnice.user_groups (name, description)\n" +
                         "VALUES ('${userGroup.name}', '${userGroup.description}');"

        val userGroupId = dbConnector.executeUpdateQuery(inputQuery)

        //TODO: update foreign keys in users table
    }
}
