package org.compose_projects.socialLocal.core.data.data

data class UserProvider (
    val userID: Int,
    val iAm: Boolean,
    val isFriend: Boolean,
    val dataChatID: Int = 0
)