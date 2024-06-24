package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import org.compose_projects.socialLocal.core.data.data.ChatBubbleProvider

@Composable
fun ChatProviderList(chatBubbleProvider: List<ChatBubbleProvider>) {
    LazyColumn {
        items(chatBubbleProvider) { chatProvider ->
            ChatProviderItem(chatProvider)
        }


    }
}
