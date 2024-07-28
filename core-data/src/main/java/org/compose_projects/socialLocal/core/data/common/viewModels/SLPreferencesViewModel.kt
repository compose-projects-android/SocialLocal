package org.compose_projects.socialLocal.core.data.common.viewModels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import org.compose_projects.socialLocal.core.data.common.states.SLPreferencesState
import org.compose_projects.socialLocal.core.data.data.SLPreferencesProvider
import org.compose_projects.socialLocal.core.data.repository.SLPreferencesRepository
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


@HiltViewModel
class SLPreferencesViewModel @Inject constructor(
    private val slPreferencesRepository: SLPreferencesRepository
): ViewModel() {

    val preferencesState: StateFlow<SLPreferencesState> = slPreferencesRepository
        .preferences.map<List<SLPreferencesProvider>, SLPreferencesState> { SLPreferencesState.Success(data = it) }
        .catch { emit(SLPreferencesState.Error(it)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), SLPreferencesState.Loading)


    private val _userName = MutableStateFlow("")
    val userName: StateFlow<String> get() = _userName

    private val _description = MutableStateFlow("")
    val description: StateFlow<String> get() = _description

    private val _pathImageProfile = MutableStateFlow("")
    val pathImageProfile: StateFlow<String> get() = _pathImageProfile

    fun updateUserName(userName: String) =
        viewModelScope.launch(Dispatchers.IO) {
            _userName.value = userName
        }

    fun updateDescription(description: String) =
        viewModelScope.launch(Dispatchers.IO) {
            _description.value = description
        }

    fun updatePathImageProfile(path: String) =
        viewModelScope.launch(Dispatchers.IO) {
            _pathImageProfile.value = path
        }

    // this of down is from the room

    fun insertPreferences(preferences: SLPreferencesProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            slPreferencesRepository.insert(preferences)
        }

    fun updatePreferences(preferences: SLPreferencesProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            slPreferencesRepository.update(preferences)
        }

    fun deletePreferences(preferences: SLPreferencesProvider) =
        viewModelScope.launch(Dispatchers.IO) {
            slPreferencesRepository.delete(
                preferences
            )
        }
}