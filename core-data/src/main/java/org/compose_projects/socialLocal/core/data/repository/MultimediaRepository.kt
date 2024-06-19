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
import org.compose_projects.socialLocal.core.database.daos.Multimedia
import org.compose_projects.socialLocal.core.database.daos.MultimediaDao
import javax.inject.Inject

interface MultimediaRepository {
    val multimedia: Flow<List<MultimediaProvider>>
    suspend fun insert(
        multimediaProvider: MultimediaProvider
    )

    suspend fun update(
        multimediaProvider: MultimediaProvider
    )

    suspend fun delete(
        multimediaProvider: MultimediaProvider
    )
}

class MultimediaRepositoryImp @Inject constructor(
    private val multimediaDao: MultimediaDao
) : MultimediaRepository {

    override val multimedia: Flow<List<MultimediaProvider>> =
        multimediaDao.getMultimedia().map { items ->
            //if items.map is null MultimediaProvider returner " " in your respective item
            items.map {
                MultimediaProvider(
                    multimediaID = it.multimediaID,
                    pathImage = it.pathImage ?: "",
                    pathVideo = it.pathVideo ?: "",
                    pathDocument = it.pathDocument ?: "",
                    pathAudio = it.pathAudio ?: "",
                    message = it.message ?: ""
                )
            }
        }


    override suspend fun insert(multimediaProvider: MultimediaProvider) {
        multimediaDao.insertMultimedia(
            Multimedia(
                multimediaID = multimediaProvider.multimediaID,
                pathImage = multimediaProvider.pathImage,
                pathVideo = multimediaProvider.pathVideo,
                pathDocument = multimediaProvider.pathDocument,
                pathAudio = multimediaProvider.pathAudio,
                message = multimediaProvider.message
            )
        )
    }

    override suspend fun update(multimediaProvider: MultimediaProvider) {
        multimediaDao.updateMultimedia(
            Multimedia(
                multimediaID = multimediaProvider.multimediaID,
                pathImage = multimediaProvider.pathImage,
                pathVideo = multimediaProvider.pathVideo,
                pathDocument = multimediaProvider.pathDocument,
                pathAudio = multimediaProvider.pathAudio,
                message = multimediaProvider.message
            )
        )
    }



    override suspend fun delete(multimediaProvider: MultimediaProvider) {
        multimediaDao.deleteMultimedia(
            Multimedia(
                multimediaID = multimediaProvider.multimediaID,
                pathImage = multimediaProvider.pathImage,
                pathVideo = multimediaProvider.pathVideo,
                pathDocument = multimediaProvider.pathDocument,
                pathAudio = multimediaProvider.pathAudio,
                message = multimediaProvider.message
            )
        )
    }
}