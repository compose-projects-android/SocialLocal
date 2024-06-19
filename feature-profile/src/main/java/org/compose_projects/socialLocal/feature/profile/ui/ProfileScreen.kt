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

package org.compose_projects.socialLocal.feature.profile.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.compose_projects.socialLocal.core.data.data.ChatProvider
import org.compose_projects.socialLocal.core.data.data.MultimediaProvider
import org.compose_projects.socialLocal.core.data.data.ProfileProvider
import org.compose_projects.socialLocal.feature.profile.ui.states.ChatState
import org.compose_projects.socialLocal.feature.profile.ui.states.MultimediaState


@Composable
fun ProfileScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        SampleViewChat()
    }
}


@Composable
fun SampleViewChat(profileViewModel: ProfileViewModel = hiltViewModel()) {
    val uiState = profileViewModel.multimediaState.collectAsState().value
    Column {
        Button(onClick = { profileViewModel.insertChat(
            MultimediaProvider(
                pathImage = "/Documents/Media/ChatGlobal/images/image1.png",
                pathVideo =  "/Documents/Media/ChatGlobal/videos/video.mp4",
                pathAudio = "/Documents/Media/ChatGlobal/audios/audio.mp3",
                pathDocument = "/Documents/Media/ChatGlobal/documents/document.dock",
                message = "Hi world, i am Less and this is a test de room and databases"
            )
        ) }) {
            Text(text = "Insert Data")
        }

        Button(onClick = { profileViewModel.deleteChat(
            ChatProvider(
                chatID = 0,
                isChatGlobal = false
            )
        ) }) {
            Text(text = "Delete Data")
        }

        when (uiState) {
            is MultimediaState.Loading -> {
                // Show a loading indicator
                CircularProgressIndicator()
            }
            is MultimediaState.Error -> {
                // Show an error message
                val error = (uiState as MultimediaState.Error).throwable
                Text(text = "Error: ${error.message}")
            }
            is MultimediaState.Success -> {
                // Show the list of ChatProviders
                val chatProviders = (uiState as MultimediaState.Success).data
                ChatProviderList(chatProviders)
            }
        }
    }
}


@Composable
fun ChatProviderList(chatProviders: List<MultimediaProvider>) {
    LazyColumn {
        items(chatProviders) { chatProvider ->
            ChatProviderItem(chatProvider)
        }
    }
}

@Composable
fun ChatProviderItem(chatProvider: MultimediaProvider) {
    // Customize the item UI as needed
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(90.dp)){

        Text(text = chatProvider.message, modifier = Modifier.align(Alignment.TopCenter))

        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Row {
                Text(text = chatProvider.pathAudio)
                Text(text = chatProvider.pathVideo)
            }
            Row {
                Text(text = chatProvider.pathImage)
                Text(text = chatProvider.pathDocument)
            }
        }
    }
}

