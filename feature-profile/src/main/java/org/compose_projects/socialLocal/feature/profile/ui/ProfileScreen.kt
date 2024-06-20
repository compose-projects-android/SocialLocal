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

package org.compose_projects.socialLocal.feature.profile.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.ConfigTest
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.TestRoomAndHilt


@Composable
fun ProfileScreen() {
    Box(Modifier.fillMaxSize(1F), contentAlignment = Alignment.TopCenter) {
        TestRoomAndHilt(configTest = ConfigTest(
            chatEntity = false,
            profileEntity = false,
            userEntity = true,
            dataChatEntity = false,
            multimediaEntity = true
        ))
    }
}

