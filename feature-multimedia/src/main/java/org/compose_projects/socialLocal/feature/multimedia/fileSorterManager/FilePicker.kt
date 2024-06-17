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

internal class FilePicker(private val context: Context) {
    fun addImage(uri: Uri, typeChat: String, nameFile: String) =
        FileManager(
            context = context,
            uri = uri,
            typeChat = typeChat,
            nameFile = nameFile
        ).addImage()

    fun addVideo(uri: Uri, typeChat: String, nameFile: String) =
        FileManager(
            context = context,
            uri = uri,
            typeChat = typeChat,
            nameFile = nameFile
        ).addVideo()

    fun addDocument(uri: Uri, typeChat: String, nameFile: String) =
        FileManager(
            context = context,
            uri = uri,
            typeChat = typeChat,
            nameFile = nameFile
        ).addDocument()

    fun addAudio(uri: Uri, typeChat: String, nameFile: String) =
        FileManager(
            context = context,
            uri = uri,
            typeChat = typeChat,
            nameFile = nameFile

        ).addAudio()
}

