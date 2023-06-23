package com.splitnice.repositories

import com.splitnice.domain.UserGroup
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class UserGroupRepoImpl @Inject constructor(
    private val dbConnector: DBConnector,
    private val userRepo: UserRepo) : UserGroupRepo {
    override fun createUserGroup(userGroup: UserGroup) {
        val inputQuery = "INSERT INTO splitnice.user_groups (name, description)\n" +
                         "VALUES ('${userGroup.name}', '${userGroup.description}');"

        val userGroupId = dbConnector.executeUpdateQuery(inputQuery)

        for (user in userGroup.users){
            userRepo.updateGroupForUser(user.id, userGroupId)
        }
    }

    override fun getUserGroup(groupId: Int): UserGroup {
        val inputQuery = "SELECT * FROM user_groups WHERE id = ${groupId};"

        val result = dbConnector.getResultFromQuery(inputQuery)

        val id = result.getInt("id")
        val name = result.getString("name")
        val description = result.getString("description")

        val users = userRepo.getUsersByGroup(groupId)

        TODO("Not yet implemented")
    }
}
