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

package org.compose_projects.socialLocal.core.ui.colorPreferences

import androidx.compose.ui.graphics.Color

internal object SLTheme {
    val defaultStyle: SLThemeConfig
        get() = object: SLThemeConfig {
            override val BackgroundColor: Color
                get() = SL_theme_default_BackgroundColor
            override val TextTopAppBarColor: Color
                get() = SL_theme_default_TextTopAppBarColor
            override val BackgroundTopAppBarColor: Color
                get() = SL_theme_default_BackgroundTopAppBarColor
            override val BackgroundBottomAppBarColor: Color
                get() = SL_theme_default_BackgroundBottomAppBarColor
            override val IconSelectedBottomAppBarColor: Color
                get() = SL_theme_default_IconSelectedBottomAppBarColor
            override val IconUnSelectedBottomAppBarColor: Color
                get() = SL_theme_default_IconUnSelectedBottomAppBarColor
            override val BackgroundIconButtonAppBarColor: Color
                get() = SL_theme_default_backgroundIconBottomAppBarColor
            override val BackgroundBottomSheetsColor: Color
                get() = SL_theme_default_BackgroundBottomSheetsColor
            override val BackgroundChatBubblesLeft: Color
                get() = SL_theme_default_BackgroundChatBubblesLeft
            override val BackgroundChatBubblesRight: Color
                get() = SL_theme_default_BackgroundChatBubblesRight
            override val BackgroundTriangleChatBubblesLeft: Color
                get() = SL_theme_default_BackgroundTriangleChatBubblesLeft
            override val BackgroundTriangleChatBubblesRight: Color
                get() = SL_theme_default_BackgroundTriangleChatBubblesRight
            override val IconsColor: Color
                get() = SL_theme_default_IconsColor
            override val BackgroundButtonsColor: Color
                get() = SL_theme_default_BackgroundButtonsColor
            override val ColorParagraphs: Color
                get() = SL_theme_default_ColorParagraphs
            override val ColorTitles: Color
                get() = SL_theme_default_ColorTitles
        }

    val blackStyle: SLThemeConfig
        get() = object: SLThemeConfig {
            override val BackgroundColor: Color
                get() = SL_theme_black_BackgroundColor
            override val TextTopAppBarColor: Color
                get() = SL_theme_black_TextTopAppBarColor
            override val BackgroundTopAppBarColor: Color
                get() = SL_theme_black_BackgroundTopAppBarColor
            override val BackgroundBottomAppBarColor: Color
                get() = SL_theme_black_BackgroundBottomAppBarColor
            override val IconSelectedBottomAppBarColor: Color
                get() = SL_theme_black_IconSelectedBottomAppBarColor
            override val IconUnSelectedBottomAppBarColor: Color
                get() = SL_theme_black_IconUnSelectedBottomAppBarColor
            override val BackgroundIconButtonAppBarColor: Color
                get() = SL_theme_black_backgroundIconBottomAppBarColor
            override val BackgroundBottomSheetsColor: Color
                get() = SL_theme_black_BackgroundBottomSheetsColor
            override val BackgroundChatBubblesLeft: Color
                get() = SL_theme_black_BackgroundChatBubblesLeft
            override val BackgroundChatBubblesRight: Color
                get() = SL_theme_black_BackgroundChatBubblesRight
            override val BackgroundTriangleChatBubblesLeft: Color
                get() = SL_theme_black_BackgroundTriangleChatBubblesLeft
            override val BackgroundTriangleChatBubblesRight: Color
                get() = SL_theme_black_BackgroundTriangleChatBubblesRight
            override val IconsColor: Color
                get() = SL_theme_black_IconsColor
            override val BackgroundButtonsColor: Color
                get() = SL_theme_black_BackgroundButtonsColor
            override val ColorParagraphs: Color
                get() = SL_theme_black_ColorParagraphs
            override val ColorTitles: Color
                get() = SL_theme_black_ColorTitles
        }
}