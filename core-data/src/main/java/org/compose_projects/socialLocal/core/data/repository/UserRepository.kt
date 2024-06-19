/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.compose_projects.socialLocal.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.compose_projects.socialLocal.core.data.data.UserProvider
import org.compose_projects.socialLocal.core.database.daos.UserDao
import org.compose_projects.socialLocal.core.database.daos.User
import javax.inject.Inject

interface UserRepository {
    val user: Flow<List<UserProvider>>

    suspend fun insert(
        userProvider: UserProvider
    )

    suspend fun update(
        userProvider: UserProvider
    )

    suspend fun delete(
        userProvider: UserProvider
    )
}

class UserRepositoryImp @Inject constructor(
    private val userDao: UserDao
) : UserRepository {

    override val user: Flow<List<UserProvider>> =
        userDao.getUser().map { items ->
            items.map {
                UserProvider(
                    userID = it.userID,
                    iAm = it.iAm,
                    isFriend = it.isFriend,
                    //dataChatID = it.dataChatID
                )
            }
        }

    override suspend fun insert(userProvider: UserProvider) {
        userDao.insertUser(
            User(
                userID = userProvider.userID,
                iAm = userProvider.iAm,
                isFriend = userProvider.isFriend,
                //dataChatID = userProvider.dataChatID
            )
        )
    }

    override suspend fun update(userProvider: UserProvider) {
        userDao.updateUser(
            User(
                userID = userProvider.userID,
                iAm = userProvider.iAm,
                isFriend = userProvider.isFriend,
                //dataChatID = userProvider.dataChatID
            )
        )
    }

    override suspend fun delete(userProvider: UserProvider) {
        userDao.deleteUser(
            User(
                userID = userProvider.userID,
                iAm = userProvider.iAm,
                isFriend = userProvider.isFriend,
                //dataChatID = userProvider.dataChatID
            )
        )
    }


}
