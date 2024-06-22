package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import org.compose_projects.socialLocal.core.data.data.ChatProvider
import org.compose_projects.socialLocal.core.data.data.DataChatProvider
import org.compose_projects.socialLocal.core.data.data.MultimediaProvider
import org.compose_projects.socialLocal.core.data.data.ProfileProvider
import org.compose_projects.socialLocal.core.data.data.UserProvider
import androidx.compose.ui.text.TextStyle
import org.compose_projects.socialLocal.core.data.common.MultimediaViewModel

private val textStyle = TextStyle(
    color = Color.White.copy(alpha = 0.7F),
    fontSize = 16.sp,
    fontFamily = FontFamily.Monospace
)


@Composable
fun ChatProviderItem(chatProvider: ChatProvider) {

    var showDialogDelete by remember { mutableStateOf(false) }

    CampousItems(contentItem = {
        // Customize the item UI as needed
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
        ) {
            Text(
                text = chatProvider.chatID.toString(),
                modifier = Modifier.align(Alignment.TopCenter)
            )
            Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                Row {
                    Text(text = chatProvider.isChatGlobal.toString(), style = textStyle)
                    Text(text = chatProvider.profileID.toString(), style = textStyle)
                }
            }
        }
    }) {
        Button(onClick = { showDialogDelete = true }) {
            Text(text = "Edir or Delete")
        }
    }

    DialogDelete(
        state = showDialogDelete,
        title = "Chat Entity",
        providers = providers(chatProvider)
    ) {
        showDialogDelete = false
    }
}

@Composable
fun ProfileProviderItem(chatProvider: ProfileProvider) {

    var showDialogDelete by remember { mutableStateOf(false) }

    CampousItems(contentItem = {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
        ) {
            Text(
                text = chatProvider.profileID.toString(),
                modifier = Modifier.align(Alignment.TopCenter), style = textStyle
            )
            Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                Row {
                    Text(text = chatProvider.pathImageProfile, style = textStyle)
                    Text(text = chatProvider.description ?: "", style = textStyle)
                    Text(text = chatProvider.userID.toString(), style = textStyle)
                }
            }
        }
    }) {
        Button(onClick = { showDialogDelete = true }) {
            Text(text = "Edir or Delete")
        }
    }
    DialogDelete(
        state = showDialogDelete,
        title = "Profile Entity",
        providers = providers(profileProvider = chatProvider)
    ) {
        showDialogDelete = false
    }
}

@Composable
fun UserProviderItem(chatProvider: UserProvider) {

    var showDialogDelete by remember { mutableStateOf(false) }

    CampousItems(contentItem = {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
        ) {
            Text(
                text = chatProvider.userID.toString(),
                modifier = Modifier.align(Alignment.TopCenter),
                style = textStyle
            )
            Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                Row {
                    Text(text = chatProvider.iAm.toString(), style = textStyle)
                    Text(text = chatProvider.isFriend.toString(), style = textStyle)
                    Text(text = chatProvider.dataChatID.toString(), style = textStyle)
                }
            }
        }
    }) {

        Button(onClick = { showDialogDelete = true }) {
            Text(text = "Edir or Delete")
        }
    }
    DialogDelete(
        state = showDialogDelete,
        title = "Profile Entity",
        providers = providers(userProvider = chatProvider)
    ) {
        showDialogDelete = false
    }
}

@Composable
fun DataChatProviderItem(chatProvider: DataChatProvider) {
    var showDialogDelete by remember { mutableStateOf(false) }

    CampousItems(contentItem = {    // Customize the item UI as needed
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 5.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(text = "Chat ID: ${chatProvider.dataChatID}", style = textStyle)
                Text(text = "Date Time ${chatProvider.dateTime}", style = textStyle)
                Text(text = "Yo lo envie: ${chatProvider.iSend}", style = textStyle)
                Text(text = "Tipo de Contenido: ${chatProvider.contentType}", style = textStyle)
                Text(text = "Multimedia ID: ${chatProvider.multimediaID}", style = textStyle)

            }
        }
    }) {

        Button(onClick = { showDialogDelete = true }) {
            Text(text = "Edir or Delete")
        }
    }
    DialogDelete(
        state = showDialogDelete,
        title = "Profile Entity",
        providers = providers(dataChatProvider = chatProvider)
    ) {
        showDialogDelete = false
    }
}

@Composable
fun MultimediaProviderItem(
    chatProvider: MultimediaProvider,
    multimediaViewModel: MultimediaViewModel = hiltViewModel()
) {

    var showDialogDelete by remember { mutableStateOf(false) }

    CampousItems(contentItem = {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
        ) {

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .verticalScroll(
                        rememberScrollState()
                    )
            ) {

                Text(text = chatProvider.multimediaID.toString(), style = textStyle)
                Text(text = chatProvider.pathImage, style = textStyle)
                Text(text = chatProvider.pathVideo, style = textStyle)
                Text(text = chatProvider.pathDocument, style = textStyle)
                Text(text = chatProvider.pathAudio, style = textStyle)
                Text(text = chatProvider.message, style = textStyle)
            }
        }
    }) {

        Button(onClick = { showDialogDelete = true }) {
            Text(text = "Edir or Delete")
        }
    }
    DialogDelete(
        state = showDialogDelete,
        title = "Profile Entity",
        providers = providers(multimediaProvider = chatProvider)
    ) {
        showDialogDelete = false
    }
}
