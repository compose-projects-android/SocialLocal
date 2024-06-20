package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import org.compose_projects.socialLocal.core.data.data.ChatProvider
import org.compose_projects.socialLocal.core.data.data.DataChatProvider
import org.compose_projects.socialLocal.core.data.data.MultimediaProvider
import org.compose_projects.socialLocal.core.data.data.ProfileProvider
import org.compose_projects.socialLocal.core.data.data.UserProvider

@Composable
internal fun Liner(content: @Composable () -> Unit) {
    HorizontalDivider(color = Color.Red)
    content()
    HorizontalDivider(color = Color.Red)
}


@Composable
fun CampousItems(contentItem: @Composable () -> Unit, editContent: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth(0.5F)
                .align(Alignment.CenterStart)
        ) {
            contentItem()
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5F)
                .align(Alignment.CenterEnd)
        ) {
            editContent()
        }
    }
}


@Composable
internal fun Add(
    title: String
) {

    var state by remember { mutableStateOf(false) }
    Button(onClick = { state = true }) {
        Text(text = "Add item of $title")
    }

    DialogAdd(title = title, state = state, onDissmissRequest = { state = false })

}

@Composable
private fun DialogAdd(
    title: String,
    state: Boolean,
    onDissmissRequest: () -> Unit,

    ) {
    if (state) {
        Dialog(
            onDismissRequest = { onDissmissRequest() },
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            )
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                ContentAdd(entity = title)
            }
        }
    }
}


@Composable
private fun ContentAdd(
    entity: String,
    testRoomAndHiltViewModel: TestRoomAndHiltViewModel = hiltViewModel()
) {
    val chatEntity = "Chat Entity"
    val profileEntity = "Profile Entity"
    val userEntity = "User Entity"
    val dataChatEntity = "Data Chat Entity"
    val multimediaEntity = "Multimedia Entity"

    val modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)

    when (entity) {
        chatEntity -> {

            var isChatGlobal by remember { mutableStateOf("true")}

            Column {
                TextField(
                    value = isChatGlobal,
                    onValueChange = { isChatGlobal = it },
                    modifier = modifier
                )

                Button(onClick = {
                    testRoomAndHiltViewModel.insertChat(
                        ChatProvider(
                            isChatGlobal = if (isChatGlobal == "true") true else false
                        )
                    )
                }) {
                    Text(text = "Add items for $entity")
                }
            }

        }
        profileEntity -> {

            var pathImageProfile by remember { mutableStateOf("") }
            var description by remember { mutableStateOf("") }

            Column {
                TextField(
                    value = pathImageProfile,
                    onValueChange = { pathImageProfile = it },
                    modifier = modifier
                )
                TextField(
                    value = description,
                    onValueChange = { description = it },
                    modifier = modifier
                )

                Button(onClick = {
                    testRoomAndHiltViewModel.insertProfile(
                        ProfileProvider(
                            pathImageProfile = pathImageProfile,
                            description = description
                        )
                    )
                }) {
                    Text(text = "Add items for $entity")
                }
            }
        }

        userEntity -> {
            var iAm by remember { mutableStateOf("true") }
            var isFriend by remember { mutableStateOf("true") }
            Column {
                TextField(
                    value = iAm,
                    onValueChange = { iAm = it },
                    modifier = modifier
                )
                TextField(
                    value = isFriend,
                    onValueChange = { isFriend = it },
                    modifier = modifier
                )
                Button(onClick = {
                    testRoomAndHiltViewModel.insertUser(
                        UserProvider(
                            iAm = if (iAm == "true") true else false,
                            isFriend = if (isFriend == "true") true else false
                        )
                    )
                }) {
                    Text(text = "Add items for $entity")
                }
            }
        }

        dataChatEntity -> {

            var dateTime by remember { mutableStateOf("") }
            var iSend by remember { mutableStateOf("true") }
            var contentType by remember { mutableStateOf("") }

            Column {
                TextField(
                    value = dateTime,
                    onValueChange = { dateTime = it },
                    modifier = modifier
                )
                TextField(
                    value = iSend,
                    onValueChange = { iSend = it },
                    modifier = modifier
                )
                TextField(
                    value = contentType,
                    onValueChange = { contentType = it },
                    modifier = modifier
                )

                Button(onClick = {
                    testRoomAndHiltViewModel.insertDataChat(
                        DataChatProvider(
                            dateTime = dateTime,
                            iSend = if (iSend == "true") true else false,
                            contentType = contentType
                        )
                    )
                }) {
                    Text(text = "Add items for $entity")
                }

            }
        }

        multimediaEntity -> {

            var pathImage by remember { mutableStateOf("") }
            var pathVideo by remember { mutableStateOf("") }
            var pathDocument by remember { mutableStateOf("") }
            var pathAudio by remember { mutableStateOf("") }
            var message by remember { mutableStateOf("") }

            Column {
                TextField(
                    value = pathImage,
                    onValueChange = { pathImage = it },
                    modifier = modifier
                )
                TextField(
                    value = pathVideo,
                    onValueChange = { pathVideo = it },
                    modifier = modifier
                )
                TextField(
                    value = pathDocument,
                    onValueChange = { pathDocument = it },
                    modifier = modifier
                )
                TextField(
                    value = pathAudio,
                    onValueChange = { pathAudio = it },
                    modifier = modifier
                )
                TextField(
                    value = message,
                    onValueChange = { message = it },
                    modifier = modifier
                )
                Button(onClick = {
                    testRoomAndHiltViewModel.insertMultimedia(
                        MultimediaProvider(
                            pathImage = pathImage,
                            pathVideo = pathVideo,
                            pathDocument = pathDocument,
                            pathAudio = pathAudio,
                            message = message
                        )
                    )
                }) {
                    Text(text = "Add items for $entity")
                }
            }
        }
    }
}

@Composable
internal fun EditDelete(
    value: String,
    onValueChange: (String) -> Unit,
    actionAdd: () -> Unit,
    actionDelete: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            TextField(value = value, onValueChange = { onValueChange(it) })

            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        actionAdd()
                    }
                )
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        actionDelete()
                    }
                )

            }

        }
    }
}

