package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt

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
import org.compose_projects.socialLocal.core.data.data.DataChatProvider
import org.compose_projects.socialLocal.core.data.data.MultimediaProvider
import org.compose_projects.socialLocal.core.data.data.ProfileProvider
import org.compose_projects.socialLocal.core.data.data.UserProvider
import org.compose_projects.socialLocal.core.data.repository.ChatRepository
import org.compose_projects.socialLocal.core.data.repository.DataChatRepository
import org.compose_projects.socialLocal.core.data.repository.MultimediaRepository
import org.compose_projects.socialLocal.core.data.repository.ProfileRepository
import org.compose_projects.socialLocal.core.data.repository.UserRepository
import javax.inject.Inject
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states.ChatState
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states.DataChatState
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states.MultimediaState
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states.ProfileState
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states.UserState


@HiltViewModel
class TestRoomAndHiltViewModel @Inject constructor(
    private val chatRepository: ChatRepository,
    private val profileRepository: ProfileRepository,
    private val userRepository: UserRepository,
    private val dataChatRepository: DataChatRepository,
    private val multimediaRepository: MultimediaRepository
) : ViewModel() {

    val chatState: StateFlow<ChatState> = chatRepository
        .chat.map<List<ChatProvider>, ChatState> { ChatState.Success(data = it) }
        .catch { emit(ChatState.Error(it)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ChatState.Loading)


    val profileState: StateFlow<ProfileState> = profileRepository
        .profile.map<List<ProfileProvider>, ProfileState> { ProfileState.Success(data = it) }
        .catch { emit(ProfileState.Error(it)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ProfileState.Loading)


    val userState: StateFlow<UserState> = userRepository
        .user.map<List<UserProvider>, UserState> { UserState.Success(data = it)}
        .catch { emit(UserState.Error(it)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UserState.Loading)


    val dataChatState: StateFlow<DataChatState> = dataChatRepository
        .dataChat.map<List<DataChatProvider>, DataChatState> { DataChatState.Success(data = it) }
        .catch { emit(DataChatState.Error(it)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), DataChatState.Loading)

    val multimediaState: StateFlow<MultimediaState> = multimediaRepository
        .multimedia.map<List<MultimediaProvider>, MultimediaState> { MultimediaState.Success(data = it) }
        .catch { emit(MultimediaState.Error(it)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), MultimediaState.Loading)

    fun insertChat(multimediaProvider: MultimediaProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            multimediaRepository.insert(
                MultimediaProvider(
                    pathImage = multimediaProvider.pathImage,
                    pathVideo = multimediaProvider.pathVideo,
                    pathDocument = multimediaProvider.pathDocument,
                    pathAudio = multimediaProvider.pathAudio,
                    message = multimediaProvider.message
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


    fun deleteChat(chatProvider: MultimediaProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            multimediaRepository.delete(
                MultimediaProvider(
                    multimediaID = chatProvider.multimediaID,
                    pathImage = chatProvider.pathImage,
                    pathVideo = chatProvider.pathVideo,
                    pathDocument = chatProvider.pathDocument,
                    pathAudio = chatProvider.pathAudio,
                    message = chatProvider.message
                )
            )
        }


}