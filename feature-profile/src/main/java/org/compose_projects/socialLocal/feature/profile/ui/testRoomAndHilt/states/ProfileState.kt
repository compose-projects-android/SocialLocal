package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states

import org.compose_projects.socialLocal.core.data.data.ProfileProvider

sealed interface ProfileState {
    data object Loading : ProfileState
    data class Error(val throwable: Throwable) : ProfileState
    data class Success(val data: List<ProfileProvider>) : ProfileState
}
