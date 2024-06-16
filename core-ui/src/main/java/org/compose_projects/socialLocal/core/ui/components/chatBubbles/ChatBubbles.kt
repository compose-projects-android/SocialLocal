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

package org.compose_projects.socialLocal.core.ui.components.chatBubbles

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.compose_projects.socialLocal.core.ui.R
import org.compose_projects.socialLocal.core.ui.colorPreferences.SLColor
import org.compose_projects.socialLocal.core.ui.components.videoPlayer.VideoScreen
import org.compose_projects.socialLocal.core.ui.components.videoPlayer.viewModels.ChatGlobal

@Composable
fun Bubbles(
    message: String? = null,
    image: String? = null,
    video: String? = null,
    hour: String,
    imageProfile: String,
    nameProfile: String,
    left: Boolean,
    onClickProfile: () -> Unit
) {

    var size by remember { mutableStateOf(IntSize.Zero) }

    Row(
        modifier = Modifier
            .height(IntrinsicSize.Max)
            .fillMaxWidth(),
        horizontalArrangement = if (left) Arrangement.Start else Arrangement.End
    ) {
        if (left) {
            TriangleChatBubbles(left = left)
            ContentBubbles(
                left = left,
                title = {
                    CurrentTitle(
                        imageProfile = imageProfile,
                        hour = hour,
                        nameProfile = nameProfile,
                        onClickProfile = { onClickProfile() }
                    )
                }
            ) {
                CurrentContent(message, image, video)
            }

        } else {
            ContentBubbles(
                left = left,
                title = {
                    CurrentTitle(
                        imageProfile = imageProfile,
                        hour = hour,
                        nameProfile = nameProfile,
                        onClickProfile = { onClickProfile() }
                    )
                }
            ) {
                CurrentContent(message, image, video)
            }
            TriangleChatBubbles(left = left)
        }
    }
}


@Composable
private fun CurrentTitle(
    imageProfile: String,
    nameProfile: String,
    hour: String,
    onClickProfile: () -> Unit
) {

    val currentColor by SLColor

    val images_profile = when (imageProfile) {
        images_profiles.uri1 -> R.drawable.image_profile1
        images_profiles.uri2 -> R.drawable.image_profile2
        images_profiles.uri3 -> R.drawable.image_profile3
        images_profiles.uri4 -> R.drawable.image_profile4
        else -> R.drawable.image_profile2
    }


    Row(
        modifier = Modifier
            .width(IntrinsicSize.Max)
            .padding(top = 3.dp, start = 4.dp, bottom = 3.dp, end = 3.dp),
        verticalAlignment = Alignment.Top
    ) {

        Image(
            painter = painterResource(id = images_profile),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .size(25.dp)
                .clickable { onClickProfile() },
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.width(5.dp))

        Text(
            nameProfile,
            color = currentColor.ColorTitles,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable { onClickProfile() }
        )

        Spacer(modifier = Modifier.width(15.dp))

        Text(
            "martes - $hour",
            color = currentColor.ColorTitles,
            fontSize = 9.5.sp,
            fontWeight = FontWeight.Light
        )

    }
}


@Composable
fun CurrentContent(
    message: String? = null,
    image: String? = null,
    video: String? = null,
    chatGlobal: ChatGlobal = viewModel()
) {

    val context = LocalContext.current
    val currentColor by SLColor
    val stateVisibilityVideo = chatGlobal.stateVisibility.collectAsState().value
    val mediaItems = chatGlobal.mediaItem.collectAsState().value

    if (message != null) {
        Text(
            message,
            color = currentColor.ColorParagraphs,
            modifier = Modifier.padding(5.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify
        )
    } else if (image != null) {

        val imageUri = when (image) {
            images_chat.uri1 -> R.drawable.meme1
            images_chat.uri2 -> R.drawable.meme2
            images_chat.uri3 -> R.drawable.meme3
            else -> {
                R.drawable.meme1
            }
        }

        Box(
            modifier = Modifier
                .size(300.dp)
                .padding(8.dp)
                .clip(
                    RoundedCornerShape(10.dp)
                )
                .background(color = currentColor.BackgroundColor.copy(alpha = 0.8F))
        ) {

            Image(
                painter = painterResource(
                    id = imageUri
                ),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()

            )

        }
    } else if (video != null) {
        //visualice video
        Box(
            modifier = Modifier
                .size(300.dp)
                .padding(8.dp)
                .clip(
                    RoundedCornerShape(10.dp)
                )
                .background(
                    color = currentColor.BackgroundColor.copy(alpha = 0.8F)
                )
        ) {

            Icon(
                painter = painterResource(id = R.drawable.play_ic),
                contentDescription = null,
                modifier = Modifier
                    .clickable { chatGlobal.changeStateValue(true) }
                    .align(Alignment.Center)
                    .size(80.dp),
                tint = currentColor.IconsColor
            )

        }
    }

    //show Screen Video Player
    VideoScreen(state = stateVisibilityVideo,
        //mediaItems = mediaItems,
        onDismissRequest = { chatGlobal.changeStateValue(false) }
    )

}


@Composable
private fun ContentBubbles(
    left: Boolean,
    title: @Composable () -> Unit,
    content: @Composable () -> Unit
) {

    val currentColor by SLColor
    var size by remember { mutableStateOf(IntSize.Zero) }

    LaunchedEffect(size) {
        Log.d("prueba2", "El tamaño del componente\n Heigh: ${size.height} y Width: ${size.width}")
    }

    if (left) {
        Column(
            modifier = Modifier
                .background(
                    color = currentColor.BackgroundChatBubblesLeft,
                    shape = RoundedCornerShape(8.dp, 8.dp, 8.dp, 0.dp)
                )
                .onGloballyPositioned {
                    size = it.size
                }
        ) {
            title()
            content()
        }
    } else {
        Column(
            modifier = Modifier
                .background(
                    color = currentColor.BackgroundChatBubblesRight,
                    shape = RoundedCornerShape(8.dp, 8.dp, 0.dp, 8.dp)
                )
        ) {
            title()
            content()
        }
    }
}

@Composable
private fun TriangleChatBubbles(left: Boolean) {
    val currentColor by SLColor

    Column(
        modifier = Modifier
            .background(
                color = if (left) currentColor.BackgroundTriangleChatBubblesLeft else currentColor.BackgroundTriangleChatBubblesRight,
                shape = TriangleEdgeShape(20, left)
            )
            .width(8.dp)
            .fillMaxHeight()
    ) {}
}

private class TriangleEdgeShape(
    private val sizeTriangle: Int,
    private val left: Boolean
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        if (left) {
            val trianglePath = Path().apply {
                // Empieza en la esquina inferior derecha
                moveTo(x = size.width, y = size.height)
                // Línea hacia arriba en el mismo eje x
                lineTo(x = size.width, y = size.height - this@TriangleEdgeShape.sizeTriangle)
                // Línea diagonal hacia la esquina inferior izquierda
                lineTo(x = size.width - this@TriangleEdgeShape.sizeTriangle, y = size.height)
                // Cierra el path volviendo al inicio
                close()
            }
            return Outline.Generic(path = trianglePath)
        } else {
            val trianglePath = Path().apply {
                moveTo(x = 0f, y = size.height - this@TriangleEdgeShape.sizeTriangle)
                lineTo(x = 0f, y = size.height)
                lineTo(x = 0f + this@TriangleEdgeShape.sizeTriangle, y = size.height)
            }
            return Outline.Generic(path = trianglePath)
        }
    }
}