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

package org.compose_projects.socialLocal.feature.multimedia.fileSorterManager.add

import android.content.Context
import android.net.Uri
import android.os.Environment
import android.util.Log
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS
import java.io.File
import java.io.FileOutputStream
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatglobal
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatinbox
import org.compose_projects.socialLocal.feature.multimedia.fileSorterManager.FileProvider

private const val TAG = "prueba4"
internal fun Video(
    fileProvider: FileProvider
) {
    when (fileProvider.typeChat) {
        chatglobal -> SaveVideo(
            context = fileProvider.context,
            parentDir = fileProvider.parentDirCG,
            uri = fileProvider.uri,
            nameFile = fileProvider.nameFile
        )

        chatinbox -> SaveVideo(
            context = fileProvider.context,
            parentDir = fileProvider.parentDirCG,
            uri = fileProvider.uri,
            nameFile = fileProvider.nameFile
        )
    }
}

private fun SaveVideo(
    context: Context,
    parentDir: File,
    uri: Uri,
    nameFile: String
) {
    val contentResolver = context.contentResolver
    try {
        val inputStream = contentResolver.openInputStream(uri) ?: return

        val file = File(parentDir, nameFile)

        val outputStream = FileOutputStream(file)

        val buffer = ByteArray(1024)
        var read: Int
        while (inputStream.read(buffer).also { read = it } != -1) {
            outputStream.write(buffer, 0, read)
        }

        inputStream.close()
        outputStream.flush()
        outputStream.close()

    } catch (e: Exception) {
        e.printStackTrace()
    }
}