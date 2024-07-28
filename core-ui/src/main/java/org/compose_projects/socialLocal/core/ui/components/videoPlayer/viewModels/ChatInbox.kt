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

package org.compose_projects.socialLocal.core.ui.components.videoPlayer.viewModels

import androidx.lifecycle.ViewModel
import io.sanghun.compose.video.uri.VideoPlayerMediaItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.compose_projects.socialLocal.core.ui.R

class ChatInbox: ViewModel() {

    private val _mediaItemList = MutableStateFlow<List<VideoPlayerMediaItem>>(listOf(
        VideoPlayerMediaItem.RawResourceMediaItem(
            resourceId = R.raw.video,
        )
    ))
    val mediaItemList: StateFlow<List<VideoPlayerMediaItem>> get() = _mediaItemList

    fun addMediaItem(mediaItem: VideoPlayerMediaItem) {
        // Actualizar el valor de _mediaItemList
        _mediaItemList.value += mediaItem
    }
}