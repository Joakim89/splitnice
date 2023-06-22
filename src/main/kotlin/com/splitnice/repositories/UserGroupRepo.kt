package com.splitnice.repositories

import com.splitnice.domain.UserGroup

interface UserGroupRepo {
    fun createUserGroup(userGroup: UserGroup)

    fun getUserGroup(groupId: Int): UserGroup
}