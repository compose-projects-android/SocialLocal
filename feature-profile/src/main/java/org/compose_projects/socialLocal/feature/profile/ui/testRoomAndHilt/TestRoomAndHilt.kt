package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import org.compose_projects.socialLocal.core.data.common.viewModels.MultimediaViewModel
import org.compose_projects.socialLocal.core.data.common.states.ChatBubbleState
import org.compose_projects.socialLocal.core.data.data.ChatBubbleProvider


@Composable
fun TestRoomAndHilt(
    multimediaViewModel: MultimediaViewModel = hiltViewModel()
) {
    val chatState = multimediaViewModel.chatBubbleState.collectAsState().value

    val newChatProvider = ChatBubbleProvider(
        isChatGlobal = true,
        pathImageProfile = "/media/path/image/profile.jpg",
        description = "Hola, me llamo daniel y estoy testeando room y hilt",
        userName = "Maria",
        isFriend = false,
        dateTime = "22:11",
        iSend = false,
        contentType = "text",
        message = "Hola, este es un mensaje de ejemplo"
    )

   /*
    LaunchedEffect(Unit) {
        multimediaViewModel.insertChat(
            newChatProvider
        )
    }
    */

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        when (chatState) {
            is ChatBubbleState.Loading -> {
                // Show a loading indicator
                CircularProgressIndicator()
            }

            is ChatBubbleState.Error -> {
                // Show an error message
                val error = (chatState as ChatBubbleState.Error).throwable
                Text(text = "Error: ${error.message}")
            }

            is ChatBubbleState.Success -> {
                // Show the list of ChatProviders
                val chatProviders = (chatState as ChatBubbleState.Success).data
                ChatProviderList(chatProviders)
            }
        }
    }
}





