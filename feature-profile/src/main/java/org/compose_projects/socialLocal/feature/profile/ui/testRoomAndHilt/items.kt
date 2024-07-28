package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
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

