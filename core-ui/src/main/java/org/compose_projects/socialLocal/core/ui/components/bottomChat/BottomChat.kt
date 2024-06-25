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

package org.compose_projects.socialLocal.core.ui.components.bottomChat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.compose_projects.socialLocal.core.ui.R
import org.compose_projects.socialLocal.core.ui.colorPreferences.SLColor

@Composable
fun BottomChat(
    modifier: Modifier = Modifier,
    emojiAction: () -> Unit,
    fileAction: () -> Unit,
    cameraAction: () -> Unit,
    microphoneAction: () -> Unit,
    sendAction: () -> Unit,
    bottomChatViewModel: BottomChatViewModel = viewModel()
) {
    val value = bottomChatViewModel.text.collectAsState().value
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = modifier
            .fillMaxWidth(1F)
            .height(50.dp)
    ) {

        //text messages send
        OutlinedTextField(
            value = value,
            onValueChange = { bottomChatViewModel.changeText(it) },
            modifier = modifier.fillMaxWidth(0.87F).focusRequester(focusRequester),
            shape = RoundedCornerShape(50.dp),
            placeholder = { Label() },
            leadingIcon = {
                LeadingIcon(
                    emojiAction = { emojiAction() }
                )
            },
            trailingIcon = {
                TrailingIcon(
                    fileAction = { fileAction() },
                    cameraAction = { cameraAction() }
                )
            }
        )
        //add: Icon for send todo multimedia
        SendMultimedia(
            microphone = value.isEmpty(),
            sendAction = { sendAction() },
            microphoneAction = { microphoneAction() }
        )
    }

    //i build the focused text input
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}

private val currentColor by SLColor

@Composable
private fun Label() {
    Text(
        text = "Mensaje",
        style = TextStyle(
            fontSize = 15.sp,
            color = currentColor.ColorTitles
        )
    )
}

//color preferences
private val modifier = Modifier.size(30.dp)
private val tint = currentColor.IconsColor

@Composable
private fun LeadingIcon(emojiAction: () -> Unit) {
    Icon(
        painter = painterResource(id = R.drawable.emoji_ic),
        contentDescription = null,
        modifier = modifier.clickable { emojiAction() },
        tint = tint
    )
}


@Composable
private fun TrailingIcon(fileAction: () -> Unit, cameraAction: () -> Unit) {

    Row(modifier = Modifier.padding(end = 7.dp)) {
        Icon(
            painter = painterResource(id = R.drawable.file_ic),
            contentDescription = null,
            modifier = modifier.clickable { fileAction() },
            tint = tint,

            )

        Spacer(modifier = Modifier.width(5.dp))

        Icon(
            painter = painterResource(id = R.drawable.camera_ic),
            contentDescription = null,
            modifier = modifier.clickable { cameraAction() },
            tint = tint
        )
    }
}


@Composable
fun SendMultimedia(
    microphone: Boolean,
    sendAction: () -> Unit,
    microphoneAction: () -> Unit
) {

    val modifierSendMultimedia = Modifier
        .clip(CircleShape)
        .background(currentColor.BackgroundIconButtonAppBarColor)
        .padding(10.dp)

    IconButton(
        onClick = { if (microphone) microphoneAction() else sendAction() }, modifier = Modifier
            .size(100.dp)
            .padding(3.dp)
    ) {
        Icon(
            painter = painterResource(id = if (microphone) R.drawable.microphone_ic else R.drawable.send_ic),
            contentDescription = null,
            modifier = modifierSendMultimedia,
            tint = tint
        )
    }
}