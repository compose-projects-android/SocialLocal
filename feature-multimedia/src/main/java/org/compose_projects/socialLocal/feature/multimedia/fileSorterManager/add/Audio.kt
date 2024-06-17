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

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.util.Log
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatglobal
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatinbox
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream


private const val TAG = "prueba4"

internal fun Audio(
    context: Context,
    uri: Uri,
    typeChat: String,
    parentDirCG: File,
    parentDirCI: File,
    nameFile: String
) {

    when (typeChat) {
        chatglobal -> SaveAudio(
            context = context,
            parentDir = parentDirCG,
            uri = uri,
            nameFile = nameFile
        )

        chatinbox -> SaveAudio(
            context = context,
            parentDir = parentDirCI,
            uri = uri,
            nameFile = nameFile
        )
    }

}


private fun SaveAudio(
    context: Context,
    uri: Uri,
    nameFile: String,
    parentDir: File
): Boolean {
    return try {
        // Asegúrate de que el directorio padre exista
        if (!parentDir.exists()) {
            parentDir.mkdirs()
        }

        val file = File(parentDir, nameFile)
        val contentResolver: ContentResolver = context.contentResolver
        val inputStream: InputStream? = contentResolver.openInputStream(uri)
        val outputStream = FileOutputStream(file)

        if (inputStream != null) {
            val buffer = ByteArray(1024)
            var length: Int

            while (inputStream.read(buffer).also { length = it } > 0) {
                outputStream.write(buffer, 0, length)
            }

            // Cerrar flujos
            outputStream.flush()
            outputStream.close()
            inputStream.close()
            true
        } else {
            false
        }
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }

}