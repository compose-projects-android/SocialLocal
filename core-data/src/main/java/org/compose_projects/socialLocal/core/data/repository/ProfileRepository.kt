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
import org.compose_projects.socialLocal.core.data.data.MultimediaProvider
import org.compose_projects.socialLocal.core.data.data.ProfileProvider
import org.compose_projects.socialLocal.core.database.daos.Profile
import org.compose_projects.socialLocal.core.database.daos.ProfileDao
import javax.inject.Inject

interface ProfileRepository {
    val profile: Flow<List<ProfileProvider>>
    suspend fun insert(
        profileProvider: ProfileProvider
    )

    suspend fun update(
        profileProvider: ProfileProvider
    )

    suspend fun delete(
        profileProvider: ProfileProvider
    )
}


internal class ProfileRepositoryImp @Inject constructor(
    private val profileDao: ProfileDao
): ProfileRepository {
    override val profile: Flow<List<ProfileProvider>> =
        profileDao.getProfile().map {items ->
            items.map {
                ProfileProvider(
                    profileID = it.profileID,
                    pathImageProfile = it.pathImageProfile,
                    description = it.description,
                    //userID = it.userID
                )
            }
        }

    override suspend fun insert(profileProvider: ProfileProvider) {
        profileDao.insertProfile(
            Profile(
                profileID = profileProvider.profileID ?: 0,
                pathImageProfile = profileProvider.pathImageProfile,
                description = profileProvider.description
            )
        )
    }

    override suspend fun update(profileProvider: ProfileProvider) {
        profileDao.updateProfile(
            Profile(
                profileID = profileProvider.profileID ?: 0,
                pathImageProfile = profileProvider.pathImageProfile,
                description = profileProvider.description
            )
        )
    }

    override suspend fun delete(profileProvider: ProfileProvider) {
        profileDao.deleteProfile(
            Profile(
                profileID = profileProvider.profileID ?: 0,
                pathImageProfile = profileProvider.pathImageProfile,
                description = profileProvider.description
            )
        )
    }
}