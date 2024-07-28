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
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.appname
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.audios
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatglobal
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.chatinbox
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.documents
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.images
import org.compose_projects.socialLocal.feature.multimedia.CONSTANTS.videos

internal fun configDirectories(context: Context) {
    //creating full directories of Social Local
    createAppDirectories(
        context = context,
        media = media(
            appName = appname,
            chatGlobal = chatglobal,
            chatInbox = chatinbox,
            directoryImages = images,
            directoryVideos = videos,
            directoryDocuments = documents,
            directoryAudios = audios
        )
    )
}