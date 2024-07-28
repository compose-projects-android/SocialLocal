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

package org.compose_projects.socialLocal.feature.auth.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.compose_projects.socialLocal.core.ui.colorPreferences.SLColor
import org.compose_projects.socialLocal.core.ui.colorPreferences.SLThemesList

@Composable
fun AuthScreen() {
    (0..2).forEach {
        AuthScreen(it)
    }
}

@Composable
internal fun AuthScreen(iii: Int) {
    LazyColumn(
        Modifier.fillMaxSize()
    ) {
        items(iii) {
            Text(text = it.toString(), color = Color.White)
        }
    }
    Column {
        Button(
            onClick = { SLColor.value = if (SLColor.value == SLThemesList.default) SLThemesList.black else SLThemesList.default }
        ) {
            Text(if (SLColor.value == SLThemesList.default) "Cambiar a negro" else "Cambiar a claro")
        }

    }




}