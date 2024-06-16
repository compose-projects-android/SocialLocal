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

package org.compose_projects.socialLocal.core.ui.components.prev_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import org.compose_projects.socialLocal.core.ui.R
import org.compose_projects.socialLocal.core.ui.colorPreferences.SLColor
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.images_profiles


@Composable
fun ScaleImageProfile(
    state: Boolean,
    contentProfile: ContentProfile,
    onDismissImage: () -> Unit
) {

    val image_profile = when (contentProfile.image) {
        images_profiles.uri1 -> R.drawable.image_profile1
        images_profiles.uri2 -> R.drawable.image_profile2
        images_profiles.uri3 -> R.drawable.image_profile3
        images_profiles.uri4 -> R.drawable.image_profile4
        else -> R.drawable.image_profile2
    }

    if (state) {
        Dialog(
            onDismissRequest = { onDismissImage() },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        userName = contentProfile.name,
                        onDismissImage = onDismissImage
                    )
                }
            ) {
                ImageScaled(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize(),
                    image = contentProfile.image
                )
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopAppBar(userName: String, onDismissImage: () -> Unit) {

    val currentColor by SLColor

    TopAppBar(
        title = { Text(text = userName) },
        navigationIcon = {
            IconButton(onClick = { onDismissImage() }) {
                Icon(
                    painter = painterResource(id = R.drawable.back_ic),
                    contentDescription = "Back",
                    modifier = Modifier.clickable { onDismissImage() }
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = currentColor.BackgroundBottomAppBarColor,
            navigationIconContentColor = currentColor.IconsColor,
            titleContentColor = currentColor.ColorTitles
        )
    )
}

@Composable
private fun ImageScaled(
    modifier: Modifier,
    image: String
) {

    val currentColor by SLColor

    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }
    var scale by remember { mutableFloatStateOf(1f) }

    val image_profile = when (image) {
        images_profiles.uri1 -> R.drawable.image_profile1
        images_profiles.uri2 -> R.drawable.image_profile2
        images_profiles.uri3 -> R.drawable.image_profile3
        images_profiles.uri4 -> R.drawable.image_profile4
        else -> R.drawable.image_profile2
    }

    Box(
        modifier = modifier
            .background(currentColor.BackgroundBottomAppBarColor)
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    scale = maxOf(1f, minOf(scale * zoom, 5f))
                    val maxX = (size.width * (scale - 1)) / 2
                    val minX = -maxX
                    offsetX = maxOf(minX, minOf(maxX, offsetX + pan.x))
                    val maxY = (size.height * (scale - 1)) / 2
                    val minY = -maxY
                    offsetY = maxOf(minY, minOf(maxY, offsetY + pan.y))
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = image_profile),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(
                    scaleX = maxOf(.5f, minOf(3f, scale)),
                    scaleY = maxOf(.5f, minOf(3f, scale)),
                    translationX = offsetX,
                    translationY = offsetY
                ),
        )
    }
}

