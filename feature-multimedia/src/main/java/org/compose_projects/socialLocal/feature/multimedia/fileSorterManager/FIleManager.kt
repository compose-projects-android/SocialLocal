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

package org.compose_projects.socialLocal.feature.multimedia.fileSorterManager

import android.content.Context
import android.net.Uri
import android.os.Environment

import org.compose_projects.socialLocal.feature.multimedia.fileSorterManager.add.Audio
import org.compose_projects.socialLocal.feature.multimedia.fileSorterManager.add.Document
import org.compose_projects.socialLocal.feature.multimedia.fileSorterManager.add.Image
import org.compose_projects.socialLocal.feature.multimedia.fileSorterManager.add.Video
import java.io.File


internal data class FileProvider(
    val context: Context,
    val uri: Uri,
    val typeChat: String,
    val nameFile: String,
    val parentDirCG: File,
    val parentDirCI: File

)

internal class FileManager(
    private val context: Context,
    private val uri: Uri,
    private val typeChat: String,
    private val nameFile: String
) {

    private val providerPaths: ProviderPaths = ProviderPaths()

    fun addImage() = Image(
        FileProvider(
            context = context,
            uri = uri,
            typeChat = typeChat,
            parentDirCG = providerPaths.PathImagesCG(),
            parentDirCI = providerPaths.PathImagesCI(),
            nameFile = nameFile
        )
    )

    fun addVideo() = Video(
        FileProvider(
            context = context,
            uri = uri,
            typeChat = typeChat,
            parentDirCG = providerPaths.PathVideosCG(),
            parentDirCI = providerPaths.PathVideosCI(),
            nameFile = nameFile
        )
    )

    fun addDocument() = Document(
        FileProvider(
            context = context,
            uri = uri,
            typeChat = typeChat,
            parentDirCG = providerPaths.PathDocumentsCG(),
            parentDirCI = providerPaths.PathDocumentsCI(),
            nameFile = nameFile
        )
    )

    fun addAudio() = Audio(
        context = context,
        uri = uri,
        typeChat = typeChat,
        parentDirCG = providerPaths.PathAudiosCG(),
        parentDirCI = providerPaths.PathAudiosCI(),
        nameFile = nameFile
    )
}


