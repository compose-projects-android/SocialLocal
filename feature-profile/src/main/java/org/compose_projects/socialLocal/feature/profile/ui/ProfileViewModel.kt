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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.compose_projects.socialLocal.core.data.data.ChatProvider
import org.compose_projects.socialLocal.core.data.data.UserProvider
import org.compose_projects.socialLocal.core.data.repository.ChatRepository
import javax.inject.Inject

import org.compose_projects.socialLocal.feature.profile.ui.ProfileUiState.Loading
import org.compose_projects.socialLocal.feature.profile.ui.ProfileUiState.Error
import org.compose_projects.socialLocal.feature.profile.ui.ProfileUiState.Success


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val chatRepository: ChatRepository
) : ViewModel() {

    val uiState: StateFlow<ProfileUiState> = chatRepository
        .chat.map<List<ChatProvider>, ProfileUiState> { Success(data = it) }
        .catch { emit(Error(it)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    fun insertChat(chatProvider: ChatProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            chatRepository.insert(
                ChatProvider(
                    chatID = chatProvider.chatID,
                    isChatGlobal = chatProvider.isChatGlobal,
                    profileID = chatProvider.chatID
                )
            )
        }


    fun updateChat(chatProvider: ChatProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            chatRepository.update(
                ChatProvider(
                    chatID = chatProvider.chatID,
                    isChatGlobal = chatProvider.isChatGlobal,
                    profileID = chatProvider.chatID
                )
            )
        }


    fun deleteChat(chatProvider: ChatProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            chatRepository.delete(
                ChatProvider(
                    chatID = chatProvider.chatID,
                    isChatGlobal = chatProvider.isChatGlobal,
                    profileID = chatProvider.chatID
                )
            )
        }


}


sealed interface ProfileUiState {
    data object Loading : ProfileUiState
    data class Error(val throwable: Throwable) : ProfileUiState
    data class Success(val data: List<ChatProvider>) : ProfileUiState
}
