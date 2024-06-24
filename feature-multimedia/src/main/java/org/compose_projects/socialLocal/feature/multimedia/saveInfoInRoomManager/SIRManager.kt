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

package org.compose_projects.socialLocal.feature.multimedia.saveInfoInRoomManager

import org.compose_projects.socialLocal.core.data.common.MultimediaViewModel

class SIRManager(private val multimediaViewModel: MultimediaViewModel) {


   /*
    fun insertChatBubble(
        user: String,
        pathImageProfile: String,
        iSend: Boolean,
        dateTime: String,
        typeData: String,
        pathFile: String? = null,
        message: String? = null,
        isChatGlobal: Boolean,
        idChat: Int
    ) {

        multimediaViewModel.insertChat(
            ChatProvider(
                isChatGlobal = isChatGlobal,
                profileID = idChat
            )
        )
        multimediaViewModel.insertProfile(
            ProfileProvider(
                pathImageProfile = pathImageProfile,
                userID = idChat
            )
        )
        multimediaViewModel.insertUser(
            UserProvider(
                userName = user,
                iAm = if (iSend) true else false,
                isFriend = if (!iSend) true else false,
                dataChatID = idChat
            )
        )
        multimediaViewModel.insertDataChat(
            DataChatProvider(
                dateTime = dateTime,
                iSend = iSend,
                contentType = typeData,
                multimediaID = idChat
            )
        )
        multimediaViewModel.insertMultimedia(
            MultimediaProvider(
                pathFile = pathFile,
                message = message
            )
        )
    }

    fun readChatBubble(
      idChat: Int
    ){

    }
    */


}