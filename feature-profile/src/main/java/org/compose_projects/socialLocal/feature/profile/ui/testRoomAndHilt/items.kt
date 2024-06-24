package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.text.TextStyle
import org.compose_projects.socialLocal.core.data.common.MultimediaViewModel
import org.compose_projects.socialLocal.core.data.data.ChatBubbleProvider
import org.compose_projects.socialLocal.core.ui.components.chatBubbles.Bubbles

private val textStyle = TextStyle(
    color = Color.White.copy(alpha = 0.7F),
    fontSize = 16.sp,
    fontFamily = FontFamily.Monospace
)


@Composable
fun ChatProviderItem(chatProvider: ChatBubbleProvider) {
    Bubbles(
        hour = chatProvider.dateTime,
        imageProfile = "/media/socialLocal/chat_global/profile_juan/image.png",
        nameProfile = chatProvider.userName,
        left = if (!chatProvider.iSend) true else false,
        message = chatProvider.message
    ) {

    }

}

