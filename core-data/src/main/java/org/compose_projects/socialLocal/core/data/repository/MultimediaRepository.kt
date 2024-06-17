package org.compose_projects.socialLocal.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.compose_projects.socialLocal.core.database.Multimedia
import org.compose_projects.socialLocal.core.database.MultimediaDao
import javax.inject.Inject

interface MultimediaRepository {
    val files: Flow<List<String>>
    suspend fun add(file: String)
}

class DefaultMultimediaRepository @Inject constructor(
    private val multimediaDao: MultimediaDao
) : MultimediaRepository {

    override val files: Flow<List<String>> =
        multimediaDao.getMultimedia().map { items -> items.map { it.file } }

    override suspend fun add(file: String) {
        multimediaDao.insertMedia(Multimedia(file = file))
    }
}