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

package org.compose_projects.socialLocal.core.ui.components.videoPlayer

import androidx.compose.material3.TopAppBar
import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import io.sanghun.compose.video.RepeatMode
import io.sanghun.compose.video.VideoPlayer
import io.sanghun.compose.video.controller.VideoPlayerControllerConfig
import io.sanghun.compose.video.uri.VideoPlayerMediaItem
import org.compose_projects.socialLocal.core.ui.R
import org.compose_projects.socialLocal.core.ui.colorPreferences.SLColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VideoScreen(
    state: Boolean,
    mediaItems: List<VideoPlayerMediaItem>? = null,
    onDismissRequest: () -> Unit,
    videoViewModel: VideoViewModel = viewModel()
) {
    val mediaItemList = videoViewModel.mediaItemList.collectAsState().value

    if (state) {
        Dialog(
            onDismissRequest = { onDismissRequest() },
            properties = DialogProperties(
                usePlatformDefaultWidth = false,
                decorFitsSystemWindows = false
            )
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(state = state) {
                        onDismissRequest()
                    }
                },
                contentWindowInsets = WindowInsets(0)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Video(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center),
                        mediaItems = mediaItems ?: mediaItemList
                    )
                }
            }
        }
    }
}



@Composable
private fun Video(
    modifier: Modifier = Modifier,
    mediaItems: List<VideoPlayerMediaItem>
) {
    VideoPlayer(
        mediaItems = mediaItems,
        handleLifecycle = true,
        autoPlay = true,
        usePlayerController = true,
        enablePip = false,
        handleAudioFocus = true,
        controllerConfig = VideoPlayerControllerConfig(
            showSpeedAndPitchOverlay = false,
            showSubtitleButton = false,
            showCurrentTimeAndTotalTime = true,
            showBufferingProgress = false,
            showForwardIncrementButton = true,
            showBackwardIncrementButton = true,
            showBackTrackButton = true,
            showNextTrackButton = true,
            showRepeatModeButton = false,
            showFullScreenButton = false, //true - issue unresolving
            controllerShowTimeMilliSeconds = 5_000,
            controllerAutoShow = true,
        ),
        volume = 0.5f,  // volume 0.0f to 1.0f
        repeatMode = RepeatMode.NONE,       // or RepeatMode.ALL, RepeatMode.ONE
        onCurrentTimeChanged = { },
        playerInstance = { },
        modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBar(
    state: Boolean,
    onDismissImage: () -> Unit
) {

    val currentColor by SLColor

    AnimatedVisibility(visible = state) {
        TopAppBar(
            title = {},
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
}
