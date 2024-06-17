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

