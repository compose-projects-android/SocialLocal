package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.compose_projects.socialLocal.core.data.data.ChatProvider
import org.compose_projects.socialLocal.core.data.data.DataChatProvider
import org.compose_projects.socialLocal.core.data.data.MultimediaProvider
import org.compose_projects.socialLocal.core.data.data.ProfileProvider
import org.compose_projects.socialLocal.core.data.data.UserProvider

@Composable
fun ChatProviderItem(chatProvider: ChatProvider) {
    // Customize the item UI as needed
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {
        Text(text = chatProvider.chatID.toString(), modifier = Modifier.align(Alignment.TopCenter))
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Row {
                Text(text = chatProvider.isChatGlobal.toString())
                Text(text = chatProvider.profileID.toString())
            }
        }
    }
}

@Composable
fun ProfileProviderItem(chatProvider: ProfileProvider) {
    // Customize the item UI as needed
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {
        Text(
            text = chatProvider.profileID.toString(),
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Row {
                Text(text = chatProvider.pathImageProfile)
                Text(text = chatProvider.description ?: "")
                Text(text = chatProvider.userID.toString())
            }
        }
    }
}

@Composable
fun UserProviderItem(chatProvider: UserProvider) {
    // Customize the item UI as needed
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {
        Text(text = chatProvider.userID.toString(), modifier = Modifier.align(Alignment.TopCenter))
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Row {
                Text(text = chatProvider.iAm.toString())
                Text(text = chatProvider.isFriend.toString())
                Text(text = chatProvider.dataChatID.toString())
            }
        }
    }
}

@Composable
fun DataChatProviderItem(chatProvider: DataChatProvider) {
    // Customize the item UI as needed
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {
        Column(modifier = Modifier.align(Alignment.TopCenter)) {
                Text(text = chatProvider.dataChatID.toString())
                Text(text = chatProvider.dateTime)
                Text(text = chatProvider.iSend.toString())
                Text(text = chatProvider.contentType)
                Text(text = chatProvider.multimediaID.toString())

        }
    }
}

@Composable
fun MultimediaProviderItem(
    chatProvider: MultimediaProvider,
    testRoomAndHiltViewModel: TestRoomAndHiltViewModel = hiltViewModel()
) {

    var valueMultimedia by remember { mutableStateOf("") }

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

                Text(text = chatProvider.multimediaID.toString())
                Text(text = chatProvider.pathImage)
                Text(text = chatProvider.pathVideo)
                Text(text = chatProvider.pathDocument)
                Text(text = chatProvider.pathAudio)
                Text(text = chatProvider.message)
            }
        }
    }) {
        EditDelete(value = valueMultimedia, onValueChange = { valueMultimedia = it }, actionAdd = {
            testRoomAndHiltViewModel.insertMultimedia(
                MultimediaProvider(
                    pathImage = chatProvider.pathImage,
                    pathVideo = chatProvider.pathVideo,
                    pathDocument = chatProvider.pathDocument,
                    pathAudio = chatProvider.pathAudio,
                    message = valueMultimedia
                )
            )
        }, actionDelete = {
            testRoomAndHiltViewModel.deleteMultimedia(
                MultimediaProvider(
                    multimediaID = chatProvider.multimediaID,
                    pathImage = chatProvider.pathImage,
                    pathVideo = chatProvider.pathVideo,
                    pathDocument = chatProvider.pathDocument,
                    pathAudio = chatProvider.pathAudio,
                    message = chatProvider.message
                )
            )
        })
    }
}
