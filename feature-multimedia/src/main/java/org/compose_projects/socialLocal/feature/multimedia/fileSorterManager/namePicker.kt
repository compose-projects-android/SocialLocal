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

import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.JPG
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.MP3
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.MP4
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.PDF
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.audio
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.document
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.image
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.UNKNOWN
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.video


data class PickerNames(
    val type: String,
    val nameFile: String
)

internal fun namePicker(uri: String): PickerNames {
    // Extraer la parte después de 'document/'
    val parts = uri.split("/")
    val documentPart = parts.lastOrNull()?.substringAfter("$document:") ?: UNKNOWN

    // Determinar el tipo de contenido
    val type = when {
        uri.contains(image) -> image
        uri.contains(video) -> video
        uri.contains(audio) -> audio
        uri.contains(document) -> document
        else -> UNKNOWN
    }

    // Determinar la extensión basada en el tipo
    val extension = when (type) {
        image -> JPG
        video -> MP4
        audio -> MP3
        document -> PDF
        else -> UNKNOWN
    }

    // name generated
    return PickerNames(
        type = type,
        nameFile = "$documentPart$extension".replace("%", "")
    )
}

