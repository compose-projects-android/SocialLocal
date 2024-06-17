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

import android.os.Environment
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.appname
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatglobal
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatinbox
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.images
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.videos
import java.io.File

internal class ProviderPaths {

    private val baseDir = File(
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
        appname
    )
    
    internal fun PathImagesCG(): File {

        val imagesDir = File(baseDir, images)
        val chatGlobalDir = File(imagesDir, chatglobal)
        return chatGlobalDir
    }

    internal fun PathImagesCI(): File {
        val imagesDir = File(baseDir, images)
        val chatInboxDir = File(imagesDir, chatinbox)
        return chatInboxDir
    }

    internal fun PathVideosCG(): File {
        val videosDir = File(baseDir, videos)
        val chatGlobalDir = File(videosDir, chatglobal)
        return chatGlobalDir
    }

    internal fun PathVideosCI(): File {
        val videosDir = File(baseDir, videos)
        val chatGlobalDir = File(videosDir, chatinbox)
        return chatGlobalDir
    }
}