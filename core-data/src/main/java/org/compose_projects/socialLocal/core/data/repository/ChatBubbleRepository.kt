package org.compose_projects.socialLocal.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.compose_projects.socialLocal.core.data.data.ChatBubbleProvider
import org.compose_projects.socialLocal.core.database.daos.ChatBubble
import org.compose_projects.socialLocal.core.database.daos.ChatBubbleDao
import javax.inject.Inject


interface ChatBubbleRepository {
    val chatBubble: Flow<List<ChatBubbleProvider>>
    suspend fun insert(
        chatBubbleProvider: ChatBubbleProvider
    )

    suspend fun update(
        chatBubbleProvider: ChatBubbleProvider
    )

    suspend fun delete(
        chatBubbleProvider: ChatBubbleProvider
    )
}

class ChatBubbleRepositoryImp @Inject constructor(
    private val chatBubbleDao: ChatBubbleDao
) : ChatBubbleRepository {
    override val chatBubble: Flow<List<ChatBubbleProvider>>
        get() = chatBubbleDao.getChat().map { items ->
            items.map {
                ChatBubbleProvider(
                    chatID = it.chatID,
                    isChatGlobal = it.isChatGlobal,
                    pathImageProfile = it.pathImageProfile,
                    description = it.description,
                    userName = it.userName,
                    isFriend = it.isFriend,
                    dateTime = it.dateTime,
                    iSend = it.iSend,
                    contentType = it.contentType,
                    pathFile = it.pathFile,
                    message = it.message
                )
            }
        }

    override suspend fun insert(chatBubbleProvider: ChatBubbleProvider) =
        chatBubbleDao.insertChat(
            ChatBubble(
                isChatGlobal = chatBubbleProvider.isChatGlobal,
                pathImageProfile = chatBubbleProvider.pathImageProfile,
                description = chatBubbleProvider.description,
                userName = chatBubbleProvider.userName,
                isFriend = chatBubbleProvider.isFriend,
                dateTime = chatBubbleProvider.dateTime,
                iSend = chatBubbleProvider.iSend,
                contentType = chatBubbleProvider.contentType,
                pathFile = chatBubbleProvider.pathFile,
                message = chatBubbleProvider.message
            )
        )

    override suspend fun update(chatBubbleProvider: ChatBubbleProvider) =
        chatBubbleDao.updateChat(
            ChatBubble(
                isChatGlobal = chatBubbleProvider.isChatGlobal,
                pathImageProfile = chatBubbleProvider.pathImageProfile,
                description = chatBubbleProvider.description,
                userName = chatBubbleProvider.userName,
                isFriend = chatBubbleProvider.isFriend,
                dateTime = chatBubbleProvider.dateTime,
                iSend = chatBubbleProvider.iSend,
                contentType = chatBubbleProvider.contentType,
                pathFile = chatBubbleProvider.pathFile,
                message = chatBubbleProvider.message
            )
        )

    override suspend fun delete(chatBubbleProvider: ChatBubbleProvider) =
        chatBubbleDao.deleteChat(
            ChatBubble(
                isChatGlobal = chatBubbleProvider.isChatGlobal,
                pathImageProfile = chatBubbleProvider.pathImageProfile,
                description = chatBubbleProvider.description,
                userName = chatBubbleProvider.userName,
                isFriend = chatBubbleProvider.isFriend,
                dateTime = chatBubbleProvider.dateTime,
                iSend = chatBubbleProvider.iSend,
                contentType = chatBubbleProvider.contentType,
                pathFile = chatBubbleProvider.pathFile,
                message = chatBubbleProvider.message
            )
        )
}