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
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import org.compose_projects.socialLocal.core.data.data.ChatProvider
import org.compose_projects.socialLocal.core.data.data.ProfileProvider
import org.compose_projects.socialLocal.core.database.daos.Chat
import org.compose_projects.socialLocal.core.database.daos.ChatDao
import javax.inject.Inject


interface ChatRepository {

    val chat: Flow<List<ChatProvider>>
    suspend fun insert(
        chatProvider: ChatProvider
    )

    suspend fun update(
        chatProvider: ChatProvider
    )

    suspend fun delete(
        chatProvider: ChatProvider
    )
}

class ChatRepositoryImp @Inject constructor(
    private val chatDao: ChatDao
): ChatRepository {
    override val chat: Flow<List<ChatProvider>> =
        chatDao.getChat().map { items ->
            items.map {
                ChatProvider(
                    chatID = it.chatID,
                    isChatGlobal = it.isChatGlobal,
                    profileID = it.profileID ?: 0
                )
            }
        }

    override suspend fun insert(chatProvider: ChatProvider) {
        chatDao.insertChat(
            Chat(
                isChatGlobal = chatProvider.isChatGlobal,
                profileID = chatProvider.profileID
            )
        )
    }

    override suspend fun update(chatProvider: ChatProvider) {
        chatDao.updateChat(
            Chat(
                chatID = chatProvider.chatID,
                isChatGlobal = chatProvider.isChatGlobal,
                profileID = chatProvider.profileID
            )
        )
    }

    override suspend fun delete(chatProvider: ChatProvider) {
        chatDao.deleteChat(
            Chat(
                chatID = chatProvider.chatID,
                isChatGlobal = chatProvider.isChatGlobal,
                profileID = chatProvider.profileID
            )
        )
    }
}


