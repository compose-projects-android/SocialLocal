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
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatglobal
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatinbox
import org.compose_projects.socialLocal.feature.multimedia.fileSorterManager.FileProvider
import java.io.File


private const val TAG = "prueba4"
internal fun Document(fileProvider: FileProvider) {

    when (fileProvider.typeChat) {
        chatglobal -> SaveDocument(
            context = fileProvider.context,
            parentDir = fileProvider.parentDirCG,
            uri = fileProvider.uri,
            nameFile = fileProvider.nameFile
        )

        chatinbox -> SaveDocument(
            context = fileProvider.context,
            parentDir = fileProvider.parentDirCI,
            uri = fileProvider.uri,
            nameFile = fileProvider.nameFile
        )
    }
}

private fun SaveDocument(
    context: Context,
    parentDir: File,
    uri: Uri, nameFile: String
) {
    //todo feature
}