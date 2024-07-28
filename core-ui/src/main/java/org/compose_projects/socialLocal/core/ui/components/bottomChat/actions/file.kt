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
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.graphics.drawable.toBitmap
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import kotlinx.coroutines.launch
import org.compose_projects.socialLocal.core.data.common.viewModels.MultimediaViewModel
import org.compose_projects.socialLocal.core.ui.R
import org.compose_projects.socialLocal.core.ui.colorPreferences.SLColor
import org.compose_projects.socialLocal.feature.multimedia.MultimediaManager
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.draw.clip

private const val TAG = "prueba1"

@Composable
fun FileAction(
    state: Boolean,
    userName: String,
    typeChat: String,
    multimediaViewModel: MultimediaViewModel = hiltViewModel(),
    onDismissRequest: () -> Unit
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val uri = remember { mutableStateOf<Uri?>(null) }
    var previewImageState by remember { mutableStateOf(false) }

    /*
        var directories by remember { mutableStateOf("") }
    */

    val multimediaManager: MultimediaManager = MultimediaManager(context, multimediaViewModel)

    LaunchedEffect(Unit) {
        this.launch {
            multimediaManager.apply {
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
            /*
            multimediaManager.apply {
                this.saveFile(uri = result, typeChat = typeChat)
            }
             */

            previewImageState = true
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

    PreviewImageLoaded(
        state = previewImageState,
        userName = userName,
        multimediaManager = multimediaManager,
        typeChat = typeChat,
        imageUri = Uri.parse(uri.value.toString())
    ) {
        previewImageState = false
    }
}


@Composable
fun PreviewImageLoaded(
    state: Boolean,
    userName: String,
    multimediaManager: MultimediaManager,
    imageUri: Uri,
    typeChat: String,
    onDismiss: () -> Unit
) {

    val currentColor by SLColor

    if (state) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            val context = LocalContext.current
            var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }

            LaunchedEffect(imageUri) {
                val loader = ImageLoader(context)
                val request = ImageRequest.Builder(context)
                    .data(imageUri)
                    .build()
                val result = (loader.execute(request) as SuccessResult).drawable
                imageBitmap = result.toBitmap().asImageBitmap()
            }

            Scaffold(
                topBar = {
                    TopAppBar(
                        onDismissImage = { onDismiss() }
                    )
                },
                floatingActionButton = {
                    IconButton(
                        onClick = {
                            multimediaManager.saveFile(
                                uri = imageUri,
                                typeChat = typeChat
                            )
                            onDismiss()
                        },
                        modifier = Modifier.clip(CircleShape).background(
                            currentColor.BackgroundIconButtonAppBarColor.copy(alpha = 0.7F)
                        )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.send_ic),
                            contentDescription = null,
                            tint = currentColor.IconsColor
                        )
                    }
                }
            ) {
                ImageScaled(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize(),
                    imageBitmap = imageBitmap
                )
            }
        }
    }
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopAppBar( onDismissImage: () -> Unit) {

    val currentColor by SLColor

    TopAppBar(
        title = { },
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
    imageBitmap: ImageBitmap? = null
) {

    val currentColor by SLColor

    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }
    var scale by remember { mutableFloatStateOf(1f) }


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
        imageBitmap?.let {
            Image(
                bitmap = it,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer(
                        scaleX = maxOf(.5f, minOf(3f, scale)),
                        scaleY = maxOf(.5f, minOf(3f, scale)),
                        translationX = offsetX,
                        translationY = offsetY
                    )
            )
        }
    }
}

