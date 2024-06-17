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

package org.compose_projects.socialLocal.feature.multimedia

import android.content.Context
import android.net.Uri
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.appname
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.audio
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.document
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.image
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.video
import org.compose_projects.socialLocal.feature.multimedia.directoryManager.configDirectories
import org.compose_projects.socialLocal.feature.multimedia.directoryManager.listAppDirectories
import org.compose_projects.socialLocal.feature.multimedia.fileSorterManager.FileManager
import org.compose_projects.socialLocal.feature.multimedia.fileSorterManager.FilePicker
import org.compose_projects.socialLocal.feature.multimedia.fileSorterManager.namePicker

class MultimediaManager(private val context: Context) {
    fun createDirectories() = configDirectories(context = context)
    fun treeOfDirectories() = listAppDirectories(context = context, appName = appname)

    //features for add files in the device
    fun saveFile(uri: Uri, typeChat: String) {
        val namePicker = namePicker(uri.toString())
        val filePicker = FilePicker(context)

        return when (namePicker.type) {
            image -> {
                filePicker.addImage(
                    uri = uri,
                    typeChat = typeChat,
                    nameFile = namePicker.nameFile
                )
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

            }
        }
    }


}


