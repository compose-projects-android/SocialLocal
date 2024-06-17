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

