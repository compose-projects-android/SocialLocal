package org.compose_projects.socialLocal.core.ui.colorPreferences

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import org.compose_projects.socialLocal.core.data.common.states.SLPreferencesState
import org.compose_projects.socialLocal.core.data.common.themes
import org.compose_projects.socialLocal.core.data.common.viewModels.SLPreferencesViewModel
import org.compose_projects.socialLocal.core.data.data.SLPreferencesProvider

@Composable
fun LoadingTheme(slPreferencesViewModel: SLPreferencesViewModel = hiltViewModel()) {
    val state = slPreferencesViewModel.preferencesState.collectAsState().value

    when (state) {
        is SLPreferencesState.Loading -> {
            //loading
        }

        is SLPreferencesState.Error -> {
            SLColor.value = SLThemesList.default
        }

        is SLPreferencesState.Success -> {
            val data = (state as SLPreferencesState.Success).data
            data.map {
                ToWithData(data = it, slPreferencesViewModel = slPreferencesViewModel)
            }
        }
    }
}

@Composable
private fun ToWithData(
    data: SLPreferencesProvider,
    slPreferencesViewModel: SLPreferencesViewModel
) {
    when (data.theme) {
        themes.DEFAULT -> SLColor.value = SLThemesList.default
        themes.BLACK -> SLColor.value = SLThemesList.black
        else -> SLColor.value = SLThemesList.default
    }

    slPreferencesViewModel.updateUserName(data.userName)
    slPreferencesViewModel.updateDescription(data.description ?: "SIN")
    slPreferencesViewModel.updatePathImageProfile(data.pathImageProfile ?: "SIN")
}



