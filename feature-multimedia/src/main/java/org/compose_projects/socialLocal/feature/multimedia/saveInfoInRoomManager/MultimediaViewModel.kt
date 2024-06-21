package org.compose_projects.socialLocal.feature.multimedia.saveInfoInRoomManager

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
import org.compose_projects.socialLocal.feature.multimedia.saveInfoInRoomManager.states.ChatState
import org.compose_projects.socialLocal.feature.multimedia.saveInfoInRoomManager.states.ProfileState
import org.compose_projects.socialLocal.feature.multimedia.saveInfoInRoomManager.states.UserState
import org.compose_projects.socialLocal.feature.multimedia.saveInfoInRoomManager.states.DataChatState
import org.compose_projects.socialLocal.feature.multimedia.saveInfoInRoomManager.states.MultimediaState

import javax.inject.Inject

@HiltViewModel
class MultimediaViewModel @Inject constructor(
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
        .user.map<List<UserProvider>, UserState> { UserState.Success(data = it) }
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


    //Inserts
    fun insertChat(chatProvider: ChatProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            chatRepository.insert(
                chatProvider = chatProvider
            )
        }
    fun insertProfile(profileProvider: ProfileProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            profileRepository.insert(
                profileProvider = profileProvider
            )
        }
    fun insertUser(userProvider: UserProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.insert(
                userProvider = userProvider
            )
        }
    fun insertDataChat(dataChatProvider: DataChatProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            dataChatRepository.insert(
                dataChatProvider = dataChatProvider
            )
        }
    fun insertMultimedia(multimediaProvider: MultimediaProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            multimediaRepository.insert(
                multimediaProvider = multimediaProvider
            )
        }
    //updates

    fun updateChat(chatProvider: ChatProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            chatRepository.update(
                chatProvider = chatProvider
            )
        }
    fun updateProfile(profileProvider: ProfileProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            profileRepository.update(
                profileProvider = profileProvider
            )
        }
    fun updateUser(userProvider: UserProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.update(
                userProvider = userProvider
            )
        }
    fun updatedataChat(dataChatProvider: DataChatProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            dataChatRepository.update(
                dataChatProvider = dataChatProvider
            )
        }
    fun updateMultimedia(multimediaProvider: MultimediaProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            multimediaRepository.update(
                multimediaProvider = multimediaProvider
            )
        }


    //deletes
    fun deleteChat(chatProvider: ChatProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            chatRepository.delete(
                chatProvider = chatProvider
            )
        }
    fun deleteProfile(profileProvider: ProfileProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            profileRepository.delete(
                profileProvider = profileProvider
            )
        }
    fun deleteUser(userProvider: UserProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.delete(
                userProvider = userProvider
            )
        }
    fun deleteDataChat(dataChatProvider: DataChatProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            dataChatRepository.delete(
                dataChatProvider = dataChatProvider
            )
        }
    fun deleteMultimedia(multimediaProvider: MultimediaProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            multimediaRepository.delete(
                multimediaProvider = multimediaProvider
            )
        }
}