package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import org.compose_projects.socialLocal.core.data.data.ChatProvider
import org.compose_projects.socialLocal.core.data.data.DataChatProvider
import org.compose_projects.socialLocal.core.data.data.MultimediaProvider
import org.compose_projects.socialLocal.core.data.data.ProfileProvider
import org.compose_projects.socialLocal.core.data.data.UserProvider

@Composable
fun ChatProviderList(chatProviders: List<ChatProvider>) {
    Liner {
        LazyColumn {
            items(chatProviders) { chatProvider ->
                ChatProviderItem(chatProvider)
            }
        }
    }
}

@Composable
fun ProfileProviderList(chatProviders: List<ProfileProvider>) {
    Liner {
        LazyColumn {
            items(chatProviders) { chatProvider ->
                ProfileProviderItem(chatProvider)
            }
        }
    }
}

@Composable
fun UserProviderList(chatProviders: List<UserProvider>) {
    Liner {
        LazyColumn {
            items(chatProviders) { chatProvider ->
                UserProviderItem(chatProvider)
            }
        }
    }
}

@Composable
fun DataChatProviderList(chatProviders: List<DataChatProvider>) {
    Liner {
        LazyColumn {
            items(chatProviders) { chatProvider ->
                DataChatProviderItem(chatProvider)
            }
        }
    }
}


@Composable
fun MultimediaProviderList(chatProviders: List<MultimediaProvider>) {
    Liner {
        LazyColumn {
            items(chatProviders) { chatProvider ->
                MultimediaProviderItem(chatProvider)
            }
        }
    }
}
