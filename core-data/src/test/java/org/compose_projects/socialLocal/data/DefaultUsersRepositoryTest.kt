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

package org.compose_projects.socialLocal.data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.compose_projects.socialLocal.core.data.repository.UserRepositoryImp

/**
 * Unit tests for [UserRepositoryImp].
 */
@OptIn(ExperimentalCoroutinesApi::class) // TODO: Remove when stable
class DefaultUsersRepositoryTest {

    @Test
    fun userss_newItemSaved_itemIsReturned() = runTest {
        //val repository = UserRepositoryImp(FakeUsersDao())

        //repository.add("Repository")

        //assertEquals(repository.user.first().size, 1)
    }

}

private class FakeUsersDao /*: UserDao*/ {

    /*
        private val data = mutableListOf<User>()

    override fun getUserss(): Flow<List<User>> = flow {
        emit(data)
    }

    override suspend fun insertUsers(item: User) {
        data.add(0, item)
    }
     */
}
