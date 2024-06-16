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

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch
import org.compose_projects.socialLocal.feature.multimedia.MultimediaManager


private const val TAG = "prueba1"

@Composable
fun FileAction(state: Boolean, onDismissRequest: () -> Unit) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val uri = remember { mutableStateOf<Uri?>(null) }

    /*
        var directories by remember { mutableStateOf("") }
    */

    LaunchedEffect(Unit) {
        this.launch {
            MultimediaManager(context).apply {
                this.createDirectories()
                //directories = this.treeOfDirectories()
            }

            //Log.d(TAG, directories)
        }
    }


    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { result ->
        //If the user has not selected any file, the file URI remains the same.
        if (result != null) {
            uri.value = result
            onDismissRequest()
        } else {
            onDismissRequest()
        }
    }

    //If the status is true, I open the file picker
    LaunchedEffect(state) {
        this.launch {
            if (state) {
                launcher.launch("*/*")
            }
        }
    }

    LaunchedEffect(uri.value) {
        this.launch {
            if (uri.value != null) {
                Log.d(TAG, "La Uri selecciona es: ${uri.value}")

            }
        }
    }
}