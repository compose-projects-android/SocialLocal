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

package org.compose_projects.socialLocal.feature.multimedia.directoryManager

import android.content.Context
import android.os.Environment
import java.io.File

internal fun createAppDirectories(
    context: Context,
    media: media
) {
    val baseDir = File(
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
        media.appName
    )

    if (!baseDir.exists()) {
        baseDir.mkdirs()
    }

    val imagesDir = File(baseDir, media.directoryImages)
    val videosDir = File(baseDir, media.directoryVideos)
    val audioDir = File(baseDir, media.directoryDocuments)
    val documentsDir = File(baseDir, media.directoryAudios)

    if (!imagesDir.exists()) imagesDir.mkdirs()
    if (!videosDir.exists()) videosDir.mkdirs()
    if (!audioDir.exists()) audioDir.mkdirs()
    if (!documentsDir.exists()) documentsDir.mkdirs()

    createChatDirectories(
        parentDir = imagesDir,
        cg = media.chatGlobal,
        ci = media.chatInbox
    )
    createChatDirectories(
        parentDir = videosDir,
        cg = media.chatGlobal,
        ci = media.chatInbox
    )
    createChatDirectories(
        parentDir = audioDir,
        cg = media.chatGlobal,
        ci = media.chatInbox
    )
    createChatDirectories(
        parentDir = documentsDir,
        cg = media.chatGlobal,
        ci = media.chatInbox
    )

}


private fun createChatDirectories(parentDir: File, cg: String, ci: String) {
    val chatGlobal = File(parentDir, cg)
    val chatInbox = File(parentDir, ci)

    if (!chatGlobal.exists()) chatGlobal.mkdirs()
    if (!chatInbox.exists()) chatInbox.mkdirs()
}