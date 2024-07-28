package org.compose_projects.socialLocal.core.data.common.states

import org.compose_projects.socialLocal.core.data.data.SLPreferencesProvider

interface SLPreferencesState {
    data object Loading : SLPreferencesState
    data class Error(val throwable: Throwable) : SLPreferencesState
    data class Success(val data: List<SLPreferencesProvider>) : SLPreferencesState
}