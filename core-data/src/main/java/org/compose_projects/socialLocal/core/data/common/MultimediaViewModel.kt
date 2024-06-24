package org.compose_projects.socialLocal.core.data.common

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
import org.compose_projects.socialLocal.core.data.common.states.ChatBubbleState
import org.compose_projects.socialLocal.core.data.data.ChatBubbleProvider
import org.compose_projects.socialLocal.core.data.repository.ChatBubbleRepository


import javax.inject.Inject

@HiltViewModel
class MultimediaViewModel @Inject constructor(
    private val chatBubbleRepository: ChatBubbleRepository
) : ViewModel() {

    val chatBubbleState: StateFlow<ChatBubbleState> = chatBubbleRepository
        .chatBubble.map<List<ChatBubbleProvider>, ChatBubbleState> { ChatBubbleState.Success(data = it) }
        .catch { emit(ChatBubbleState.Error(it)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ChatBubbleState.Loading)

    //Inserts
    fun insertChat(chatBubbleProvider: ChatBubbleProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            chatBubbleRepository.insert(
                chatBubbleProvider
            )
        }

    fun updateChat(chatBubbleProvider: ChatBubbleProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            chatBubbleRepository.update(
                chatBubbleProvider
            )
        }

    fun deleteChat(chatBubbleProvider: ChatBubbleProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            chatBubbleRepository.delete(
                chatBubbleProvider
            )
        }

}