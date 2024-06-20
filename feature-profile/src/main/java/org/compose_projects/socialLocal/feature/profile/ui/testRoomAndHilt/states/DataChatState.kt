package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states

import org.compose_projects.socialLocal.core.data.data.DataChatProvider

sealed interface DataChatState {
    data object Loading : DataChatState

    data class Error(val throwable: Throwable) : DataChatState

    data class Success(val data: List<DataChatProvider>) : DataChatState
}