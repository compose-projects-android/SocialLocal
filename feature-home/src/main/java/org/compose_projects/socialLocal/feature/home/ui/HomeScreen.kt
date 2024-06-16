/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.compose_projects.socialLocal.feature.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import org.compose_projects.socialLocal.core.ui.components.bottomChat.BottomChat
import org.compose_projects.socialLocal.core.ui.components.bottomChat.BottomChatViewModel
import org.compose_projects.socialLocal.core.ui.components.bottomChat.actions.EmojiAction
import org.compose_projects.socialLocal.core.ui.components.bottomChat.actions.FileAction
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.Bubbles
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.messages
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.messages_example
import org.compose_projects.socialLocal.core.ui.components.prev_profile.ContentProfile
import org.compose_projects.socialLocal.core.ui.components.prev_profile.PreviewProfile

@Composable
fun HomeScreen(bottomChatViewModel: BottomChatViewModel = viewModel()) {
    val messages: List<messages_example> = listOf(
        messages.message1,
        messages.message2,
        messages.message3,
        messages.message4,
        messages.message5,
        messages.message6,
        messages.message7,
        messages.message8,
        messages.message9,
        messages.message10,
        messages.message11,
        messages.message12,
        messages.message4,
        messages.message5,
        messages.message6,
        messages.message7,
        messages.message8,
        messages.message9,
        messages.message1,
        messages.message2,
        messages.message3,
        messages.message4,
        messages.message5,
        messages.message6,
        messages.message7,
        messages.message8,
        messages.message9,
        messages.message10,
        messages.message11,
        messages.message12,
        messages.message4,
        messages.message5,
        messages.message6,
        messages.message7,
        messages.message8,
        messages.message9,
    )
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            listState.scrollToItem(messages.lastIndex)
        }
    }

    var showProfile by remember { mutableStateOf(false) }
    var nameProfile by remember { mutableStateOf("") }
    var imageProfile by remember { mutableStateOf("") }
    var descriptionProfile by remember { mutableStateOf("") }

    //actions states for bottomChat
    var emojiState by remember { mutableStateOf(false) }
    var fileState by remember { mutableStateOf(false) }
    var cameraState by remember { mutableStateOf(false) }
    var microphoneState by remember { mutableStateOf(false) }
    var sendState by remember { mutableStateOf(false) }

    //keyboard up or down
    val keyboardController = LocalSoftwareKeyboardController.current


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.93F),
            verticalArrangement = Arrangement.Top
        ) {
            items(messages) {

                Bubbles(
                    message = it.message,
                    image = it.image,
                    video = it.video,
                    //video = it.video,
                    left = it.left,
                    hour = it.hour,
                    imageProfile = it.imageProfile,
                    nameProfile = it.nameProfile,
                ) {
                    showProfile = true
                    nameProfile = it.nameProfile
                    imageProfile = it.imageProfile
                    descriptionProfile =
                        if (it.descriptionProfile != null) it.descriptionProfile.toString() else "Sin Descripción"
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        //add: updated the actions for each item
        BottomChat(modifier = Modifier.align(Alignment.BottomCenter).padding(horizontal = 4.dp),
            emojiAction = {
                emojiState = true
                keyboardController?.hide()
            },
            fileAction = { fileState = true },
            cameraAction = { cameraState = true },
            microphoneAction = { microphoneState = true },
            sendAction = { sendState = true }
        )


        //Actions for bottomChat
        EmojiAction(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.45F)
                .align(Alignment.BottomCenter),
            state = emojiState,
            emoji = {
                bottomChatViewModel.addEmojiForText(it)
                emojiState = false
                keyboardController?.show()
            }
        ) {
            emojiState = false
            keyboardController?.show()
        }

        FileAction(state = fileState) {
            fileState = false
        }

    }

    PreviewProfile(
        state = showProfile,
        contentProfile = ContentProfile(
            name = nameProfile,
            image = imageProfile,
            description = descriptionProfile
        ),
    ) {
        showProfile = false
    }

    LaunchedEffect(Unit) {
        keyboardController?.hide()
    }


}


/*

@Composable
fun HomeScreen(modifier: Modifier = Modifier, homeViewModel: HomeViewModel = hiltViewModel()) {
    val items by homeViewModel.uiState.collectAsStateWithLifecycle()
    if (items is Success) {
        HomeScreen(
            listItems = (items as Success).data,
            onSave = { name -> homeViewModel.addUsers(name) },
            modifier = modifier
        )
    }
}

@Composable
internal fun HomeScreen(
    listItems: List<String>,
    onSave: (name: String) -> Unit,
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf("") }
    Column {
        OutlinedTextField(value = text, onValueChange = { text = it })
        LazyColumn {
            items(listItems){
                Text(text = it)
                HorizontalDivider()
            }
        }
    }

}
 */