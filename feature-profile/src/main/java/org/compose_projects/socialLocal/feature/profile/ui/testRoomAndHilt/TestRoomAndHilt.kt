package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states.ChatState
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states.DataChatState
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states.MultimediaState
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states.ProfileState
import org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt.states.UserState


@Composable
fun TestRoomAndHilt(
    configTest: ConfigTest,
    testRoomAndHiltViewModel: TestRoomAndHiltViewModel = hiltViewModel()
) {
    //states
    val chatState = testRoomAndHiltViewModel.chatState.collectAsState().value
    val profileState = testRoomAndHiltViewModel.profileState.collectAsState().value
    val userState = testRoomAndHiltViewModel.userState.collectAsState().value
    val dataChatState = testRoomAndHiltViewModel.dataChatState.collectAsState().value
    val multimediaState = testRoomAndHiltViewModel.multimediaState.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (configTest.chatEntity) {
            when (chatState) {
                is ChatState.Loading -> {
                    // Show a loading indicator
                    CircularProgressIndicator()
                }

                is ChatState.Error -> {
                    // Show an error message
                    val error = (chatState as ChatState.Error).throwable
                    Text(text = "Error: ${error.message}")
                }

                is ChatState.Success -> {
                    // Show the list of ChatProviders
                    val chatProviders = (chatState as ChatState.Success).data
                    val title = "Chat Entity"
                    HorizontalDivider()
                    CampousItems(contentItem = {
                        Text(
                            text = title,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }) {
                        Add(title = title)
                    }
                    ChatProviderList(chatProviders)
                }
            }
        }


        if (configTest.profileEntity) {
            when (profileState) {
                is ProfileState.Loading -> {
                    // Show a loading indicator
                    CircularProgressIndicator()
                }

                is ProfileState.Error -> {
                    // Show an error message
                    val error = (profileState as ProfileState.Error).throwable
                    Text(text = "Error: ${error.message}")
                }

                is ProfileState.Success -> {
                    // Show the list of ChatProviders
                    val chatProviders = (profileState as ProfileState.Success).data
                    val title = "Profile Entity"
                    HorizontalDivider()
                    CampousItems(contentItem = {
                        Text(
                            text = title,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }) {
                        Add(title = title)
                    }
                    ProfileProviderList(chatProviders)
                }
            }
        }



        if (configTest.userEntity) {
            when (userState) {
                is UserState.Loading -> {
                    // Show a loading indicator
                    CircularProgressIndicator()
                }

                is UserState.Error -> {
                    // Show an error message
                    val error = (userState as UserState.Error).throwable
                    Text(text = "Error: ${error.message}")
                }

                is UserState.Success -> {
                    // Show the list of ChatProviders
                    val chatProviders = (userState as UserState.Success).data
                    val title = "User Entity"
                    HorizontalDivider()
                    CampousItems(contentItem = {
                        Text(
                            text = title,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }) {
                        Add(title = title)
                    }
                    UserProviderList(chatProviders)
                }
            }
        }


        if (configTest.dataChatEntity){
            when (dataChatState) {
                is DataChatState.Loading -> {
                    // Show a loading indicator
                    CircularProgressIndicator()
                }

                is DataChatState.Error -> {
                    // Show an error message
                    val error = (dataChatState as DataChatState.Error).throwable
                    Text(text = "Error: ${error.message}")
                }

                is DataChatState.Success -> {
                    // Show the list of ChatProviders
                    val chatProviders = (dataChatState as DataChatState.Success).data
                    val title = "Data Chat Entity"
                    HorizontalDivider()
                    CampousItems(contentItem = {
                        Text(
                            text = title,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }) {
                        Add(title = title)
                    }
                    DataChatProviderList(chatProviders)
                }
            }
        }


        if (configTest.multimediaEntity){
            when (multimediaState) {
                is MultimediaState.Loading -> {
                    // Show a loading indicator
                    CircularProgressIndicator()
                }

                is MultimediaState.Error -> {
                    // Show an error message
                    val error = (multimediaState as MultimediaState.Error).throwable
                    Text(text = "Error: ${error.message}")
                }

                is MultimediaState.Success -> {
                    // Show the list of ChatProviders
                    val chatProviders = (multimediaState as MultimediaState.Success).data
                    val title = "Multimedia Entity"
                    HorizontalDivider()
                    CampousItems(contentItem = {
                        Text(
                            text = title,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }) {
                        Add(title = title)
                    }
                    MultimediaProviderList(chatProviders)
                }
            }
        }
    }
}





