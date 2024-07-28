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

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.compose_projects.socialLocal.core.ui.colorPreferences.SLColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreviewProfile(
    state: Boolean,
    contentProfile: ContentProfile,
    onDismissRequest: () -> Unit
) {

    val currentColor by SLColor

    if (state) {
        ModalBottomSheet(
            onDismissRequest = {
                onDismissRequest()
            },
            containerColor = currentColor.BackgroundBottomAppBarColor,
            modifier = Modifier.fillMaxHeight(0.9F)
        ) {
            // content
            ContentPreview(contentProfile = contentProfile)

        }
    }
}
