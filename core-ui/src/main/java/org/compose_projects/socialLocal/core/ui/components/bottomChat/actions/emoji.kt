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

package org.compose_projects.socialLocal.core.ui.components.bottomChat.actions

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.emoji2.emojipicker.EmojiPickerView
import org.compose_projects.socialLocal.core.ui.R
import org.compose_projects.socialLocal.core.ui.colorPreferences.SLColor


@Composable
fun EmojiAction(
    modifier: Modifier = Modifier,
    state: Boolean,
    emoji: (String) -> Unit,
    onDismissRequest: () -> Unit
) {

    val currentColor by SLColor

    AnimatedVisibility(
        visible = state,
        modifier = modifier
            .background(currentColor.BackgroundColor.copy(alpha = 0.8F))
    ) {
        Column {
            Icon(painter = painterResource(id = R.drawable.back_ic),
                contentDescription = null, modifier = Modifier.clickable {
                    onDismissRequest()
                }.align(Alignment.Start).padding(5.dp).size(25.dp),
                tint = currentColor.IconsColor
            )
            AndroidView(
                factory = { context ->
                    EmojiPickerView(context).apply {
                        this.setOnEmojiPickedListener {
                            emoji(it.emoji)
                        }

                    }
                }, modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

