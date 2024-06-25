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
import android.widget.Toast
import org.compose_projects.socialLocal.core.data.common.MultimediaViewModel
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.audio
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.document
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.image
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.video

private class FilePicker(private val context: Context) {
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



internal fun  SaveFile(context: Context, uri: Uri, typeChat: String, multimediaViewModel: MultimediaViewModel) {
    val namePicker = namePicker(uri.toString())
    val filePicker = FilePicker(context)

    return when (namePicker.type) {
        image -> {
            filePicker.addImage(
                uri = uri,
                typeChat = typeChat,
                nameFile = namePicker.nameFile
            )
            Toast.makeText(context, "Imagen ${namePicker.nameFile} guardada exitosamente.", Toast.LENGTH_SHORT).show()
        }

        video -> {
            filePicker.addVideo(
                uri = uri,
                typeChat = typeChat,
                nameFile = namePicker.nameFile
            )
        }

        audio -> {
            filePicker.addAudio(
                uri = uri,
                typeChat = typeChat,
                nameFile = namePicker.nameFile
            )
        }

        document -> {
            filePicker.addDocument(
                uri = uri,
                typeChat = typeChat,
                nameFile = namePicker.nameFile
            )
        }

        else -> {
            Toast.makeText(context, "Archivo no válido", Toast.LENGTH_SHORT).show()
        }
    }
}

