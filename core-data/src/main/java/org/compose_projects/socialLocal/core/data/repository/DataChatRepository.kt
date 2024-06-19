package org.compose_projects.socialLocal.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.compose_projects.socialLocal.core.data.data.DataChatProvider
import org.compose_projects.socialLocal.core.database.daos.DataChat
import org.compose_projects.socialLocal.core.database.daos.DataChatDao
import javax.inject.Inject

interface DataChatRepository {

    val dataChat: Flow<List<DataChatProvider>>
    suspend fun insert(
        dataChatProvider: DataChatProvider
    )

    suspend fun update(
        dataChatProvider: DataChatProvider
    )

    suspend fun delete(
        dataChatProvider: DataChatProvider
    )
}


internal class DataChatRepositoryImp @Inject constructor(
    private val dataChatDao: DataChatDao
) : DataChatRepository {
    override val dataChat: Flow<List<DataChatProvider>> =
        dataChatDao.getDataChat().map { items ->
            //if items.map is null MultimediaProvider returner " " in your respective item
            items.map {
                DataChatProvider(
                    dataChatID = it.dataChatID,
                    dateTime = it.dateTime,
                    iSend = it.iSend ,
                    contentType = it.contentType,
                )
            }
        }

    override suspend fun update(dataChatProvider: DataChatProvider) {
        dataChatDao.updateDataChat(
            DataChat(
                dataChatID = dataChatProvider.dataChatID,
                dateTime = dataChatProvider.dateTime,
                iSend = dataChatProvider.iSend,
                contentType = dataChatProvider.contentType,
                multimediaID = dataChatProvider.multimediaID
            )
        )
    }

    override suspend fun insert(dataChatProvider: DataChatProvider) {
        dataChatDao.insertDataChat(
            DataChat(
                dataChatID = dataChatProvider.dataChatID,
                dateTime = dataChatProvider.dateTime,
                iSend = dataChatProvider.iSend,
                contentType = dataChatProvider.contentType,
                multimediaID = dataChatProvider.multimediaID
            )
        )
    }

    override suspend fun delete(dataChatProvider: DataChatProvider) {
        dataChatDao.deleteDataChat(
            DataChat(
                dataChatID = dataChatProvider.dataChatID,
                dateTime = dataChatProvider.dateTime,
                iSend = dataChatProvider.iSend,
                contentType = dataChatProvider.contentType,
                multimediaID = dataChatProvider.multimediaID
            )
        )
    }
}