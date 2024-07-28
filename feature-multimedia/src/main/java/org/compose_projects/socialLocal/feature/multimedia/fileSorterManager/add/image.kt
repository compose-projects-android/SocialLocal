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
import android.util.Log
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatglobal
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatinbox
import org.compose_projects.socialLocal.feature.multimedia.fileSorterManager.FileProvider
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

private const val TAG = "prueba4"
internal fun Image(
    fileProvider: FileProvider
) {

    when (fileProvider.typeChat) {
        chatglobal -> SaveImage(
            context = fileProvider.context,
            parentDir = fileProvider.parentDirCG,
            uri = fileProvider.uri,
            nameFile = fileProvider.nameFile
        )

        chatinbox -> SaveImage(
            context = fileProvider.context,
            parentDir = fileProvider.parentDirCI,
            uri = fileProvider.uri,
            nameFile = fileProvider.nameFile
        )
    }
}

private fun SaveImage(
    context: Context,
    parentDir: File,
    uri: Uri, nameFile: String
) {
    val newFile = File(parentDir, nameFile)
    if (!newFile.exists()) {
        try {
            newFile.createNewFile()
            val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
            if (inputStream != null) {
                val outputStream = FileOutputStream(newFile)
                val buffer = ByteArray(1024)
                var bytesRead: Int
                while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                    outputStream.write(buffer, 0, bytesRead)
                }
                inputStream.close()
                outputStream.close()
                //Log.d(TAG, "Se creó el archivo $nameFile correctamente")
            } else {
                //Log.e(TAG, "No se pudo abrir el InputStream de la URI")
            }
        } catch (e: IOException) {
            e.printStackTrace()
            //Log.e(TAG, "Error: $e")
        }
    }
}