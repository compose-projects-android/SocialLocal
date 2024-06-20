package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states

import org.compose_projects.socialLocal.core.data.data.ProfileProvider
import org.compose_projects.socialLocal.core.data.data.UserProvider

sealed interface UserState {
    data object Loading: UserState

    data class Error(val throwable: Throwable) : UserState

    data class Success(val data: List<UserProvider>) : UserState
}