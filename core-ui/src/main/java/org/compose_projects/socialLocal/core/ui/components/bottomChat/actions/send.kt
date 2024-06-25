package org.compose_projects.socialLocal.core.ui.components.bottomChat.actions

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.compose_projects.socialLocal.core.data.common.MultimediaViewModel
import org.compose_projects.socialLocal.core.data.common.TimeManager
import org.compose_projects.socialLocal.core.data.data.ChatBubbleProvider

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SendAction(
    state: Boolean,
    isChatGlobal: Boolean = true,
    pathImageProfile: String? = null,
    description: String? = null,
    userName: String,
    isFriend: Boolean = false,
    iSend: Boolean = false,
    contentType: String,
    message: String,
    multimediaViewModel: MultimediaViewModel = hiltViewModel(),
    onDissmissRequest: () -> Unit,
) {
    LaunchedEffect(state) {
        if (state) {
            multimediaViewModel.insertChat(
                ChatBubbleProvider(
                    isChatGlobal = isChatGlobal,
                    pathImageProfile = pathImageProfile,
                    description = description,
                    userName = userName,
                    isFriend = isFriend,
                    dateTime = TimeManager().getDateTime(),
                    iSend = iSend,
                    contentType = contentType,
                    message = message
                )
            )

            onDissmissRequest()
        }
    }
}