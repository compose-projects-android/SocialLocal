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
import org.compose_projects.socialLocal.core.database.Users
import org.compose_projects.socialLocal.core.database.UsersDao
import javax.inject.Inject

interface UsersRepository {
    val userss: Flow<List<String>>

    suspend fun add(name: String)
}

class DefaultUsersRepository @Inject constructor(
    private val usersDao: UsersDao
) : UsersRepository {

    override val userss: Flow<List<String>> =
        usersDao.getUserss().map { items -> items.map { it.name } }

    override suspend fun add(name: String) {
        usersDao.insertUsers(Users(name = name))
    }
}
