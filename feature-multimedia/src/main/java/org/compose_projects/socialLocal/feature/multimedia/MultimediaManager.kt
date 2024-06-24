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
import android.util.Log
import org.compose_projects.socialLocal.core.data.common.MultimediaViewModel
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.appname
import org.compose_projects.socialLocal.feature.multimedia.directoryManager.configDirectories
import org.compose_projects.socialLocal.feature.multimedia.directoryManager.listAppDirectories
import org.compose_projects.socialLocal.feature.multimedia.fileSorterManager.SaveFile
import org.compose_projects.socialLocal.feature.multimedia.saveInfoInRoomManager.SIRManager


class MultimediaManager(
    private val context: Context,
    private val multimediaViewModel: MultimediaViewModel
) {
    private val TAG = "ErrorMultimedia"
    fun createDirectories() = try {
        configDirectories(context = context)
    } catch (e: Exception) {
        Log.e(TAG, "Error creando directorios: $e")
    }

    fun treeOfDirectories() = try {
        listAppDirectories(context = context, appName = appname)
    } catch (e: Exception) {
        Log.e(TAG, "Error listando directorios: $e")
    }

    fun saveFile(uri: Uri, typeChat: String) = try {
        SaveFile(context = context, uri = uri, typeChat = typeChat)
    } catch (e: Exception) {
        Log.e(TAG, "Error guardando archivo: $e")
    }

   /*
    fun newChat(
        user: String,
        pathImageProfile: String,
        iSend: Boolean,
        dateTime: String,
        typeData: String,
        pathFile: String? = null,
        message: String? = null,
        isChatGlobal: Boolean,
        idChat: Int
    ) = try {
        SIRManager(multimediaViewModel).insertChatBubble(
            user = user,
            pathImageProfile = pathImageProfile,
            iSend = iSend,
            dateTime = dateTime,
            typeData = typeData,
            pathFile = pathFile,
            message = message,
            isChatGlobal = isChatGlobal,
            idChat = idChat
        )
        Log.d(TAG, "Chat guardado exitosamente")
    } catch (e: Exception) {
        Log.e(TAG, "Error guardando Chat: $e")
    }
    */

}



