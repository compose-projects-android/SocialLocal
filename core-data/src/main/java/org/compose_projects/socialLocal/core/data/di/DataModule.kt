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

package org.compose_projects.socialLocal.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.compose_projects.socialLocal.core.data.data.UserProvider
import org.compose_projects.socialLocal.core.data.repository.ChatRepository
import org.compose_projects.socialLocal.core.data.repository.ChatRepositoryImp
import org.compose_projects.socialLocal.core.data.repository.DataChatRepository
import org.compose_projects.socialLocal.core.data.repository.DataChatRepositoryImp
import org.compose_projects.socialLocal.core.data.repository.UserRepository
import org.compose_projects.socialLocal.core.data.repository.UserRepositoryImp
import org.compose_projects.socialLocal.core.data.repository.MultimediaRepository
import org.compose_projects.socialLocal.core.data.repository.MultimediaRepositoryImp
import org.compose_projects.socialLocal.core.data.repository.ProfileRepository
import org.compose_projects.socialLocal.core.data.repository.ProfileRepositoryImp
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindsUserRepository(
        usersRepository: UserRepositoryImp
    ): UserRepository

    @Singleton
    @Binds
    fun bindsMultimediaRepository(
        multimediaRepository: MultimediaRepositoryImp
    ): MultimediaRepository


    @Singleton
    @Binds
    fun bindsDataChatRepository(
        dataChatRepository: DataChatRepositoryImp
    ): DataChatRepository

    @Singleton
    @Binds
    fun bindsProfileRepository(
        profileRepository: ProfileRepositoryImp
    ): ProfileRepository

    @Singleton
    @Binds
    fun bindsChatRepository(
        chatRepository: ChatRepositoryImp
    ): ChatRepository
}


//val fakeUserss = listOf("One", "Two", "Three")
