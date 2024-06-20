package org.compose_projects.socialLocal.feature.profile.ui.testRoomAndHilt

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
internal fun Liner(content: @Composable () -> Unit) {
    HorizontalDivider(color = Color.Red)
    content()
    HorizontalDivider(color = Color.Red)
}


@Composable
fun CampousItems(contentItem: @Composable () -> Unit, editContent: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth(0.5F)
                .align(Alignment.CenterStart)
        ) {
            contentItem()
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5F)
                .align(Alignment.CenterEnd)
        ) {
            editContent()
        }
    }
}

@Composable
internal fun Edit(
    value: String,
    onValueChange: (String) -> Unit,
    actionAdd: () -> Unit,
    actionDelete: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            TextField(value = value, onValueChange = { onValueChange(it) })

            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        actionAdd()
                    }
                )
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        actionDelete()
                    }
                )

            }

        }
    }
}

