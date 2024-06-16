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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.compose_projects.socialLocal.core.ui.R
import org.compose_projects.socialLocal.core.ui.colorPreferences.SLColor
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.images_profiles

@Composable
internal fun ContentPreview(contentProfile: ContentProfile) {

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(10.dp)
    ) {
        CurrentTitle(nameProfile = contentProfile.name)
        CurrentContent(contentProfile = contentProfile)
    }

}


@Composable
private fun CurrentTitle(nameProfile: String) {
    val currentColor by SLColor

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = nameProfile,
            style = TextStyle(
                color = currentColor.ColorTitles,
                fontSize = 15.sp,
                fontWeight = FontWeight.ExtraBold
            )
        )
    }

}

@Composable
private fun CurrentContent(
    contentProfile: ContentProfile,
) {
    CurrentImageProfile(contentProfile = contentProfile)
    CurrentDescriptionProfile(descriptionProfile = contentProfile.description)
}

@Composable
private fun CurrentImageProfile(contentProfile: ContentProfile) {

    var scaleImage by remember { mutableStateOf(false) }

    val image_profile = when (contentProfile.image) {
        images_profiles.uri1 -> R.drawable.image_profile1
        images_profiles.uri2 -> R.drawable.image_profile2
        images_profiles.uri3 -> R.drawable.image_profile3
        images_profiles.uri4 -> R.drawable.image_profile4
        else -> R.drawable.image_profile2
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 10.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(id = image_profile), contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(
                    CircleShape
                )
                .clickable { scaleImage = true }
        )
    }


    ScaleImageProfile(
        state = scaleImage,
        contentProfile = contentProfile
    ) {
        scaleImage = false
    }

}

@Composable
private fun CurrentDescriptionProfile(descriptionProfile: String) {

    val currentColor by SLColor

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = descriptionProfile,
            style = TextStyle(
                color = currentColor.ColorParagraphs,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                textAlign = TextAlign.Center
            )
        )
    }

}

