package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states

import org.compose_projects.socialLocal.core.data.data.MultimediaProvider

sealed interface MultimediaState {
    data object Loading : MultimediaState

    data class Error(val throwable: Throwable) : MultimediaState

    data class Success(val data: List<MultimediaProvider>) : MultimediaState
}