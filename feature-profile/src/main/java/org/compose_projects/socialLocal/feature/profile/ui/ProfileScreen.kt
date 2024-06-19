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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import org.compose_projects.socialLocal.core.data.data.ChatProvider

@Composable
fun ProfileScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        SampleViewChat()
    }
}


@Composable
fun SampleViewChat(profileViewModel: ProfileViewModel = hiltViewModel()) {
    val uiState = profileViewModel.uiState.collectAsState().value
    Column {
        Button(onClick = { profileViewModel.insertChat(
            ChatProvider(
                isChatGlobal = false
            )
        ) }) {
            Text(text = "Insert Data")
        }

        Button(onClick = { profileViewModel.deleteChat(
            ChatProvider(
                chatID = 4,
                isChatGlobal = false
            )
        ) }) {
            Text(text = "Delete Data")
        }

        when (uiState) {
            is ProfileUiState.Loading -> {
                // Show a loading indicator
                CircularProgressIndicator()
            }
            is ProfileUiState.Error -> {
                // Show an error message
                val error = (uiState as ProfileUiState.Error).throwable
                Text(text = "Error: ${error.message}")
            }
            is ProfileUiState.Success -> {
                // Show the list of ChatProviders
                val chatProviders = (uiState as ProfileUiState.Success).data
                ChatProviderList(chatProviders)
            }
        }
    }



}


@Composable
fun ChatProviderList(chatProviders: List<ChatProvider>) {
    LazyColumn {
        items(chatProviders) { chatProvider ->
            ChatProviderItem(chatProvider)
        }
    }
}

@Composable
fun ChatProviderItem(chatProvider: ChatProvider) {
    // Customize the item UI as needed
    Text(text = "Chat ID: ${chatProvider.chatID}, Global: ${chatProvider.isChatGlobal}, Profile ID: ${chatProvider.profileID}")
}

