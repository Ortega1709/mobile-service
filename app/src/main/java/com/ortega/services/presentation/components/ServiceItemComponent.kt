package com.ortega.services.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ServiceItemComponent(
    icon: ImageVector,
    title: String,
    description: String,
    enabled: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { if (enabled) onClick() }
    ) {

        ListItem(
            leadingContent = { Icon(imageVector = icon, contentDescription = title) },
            headlineContent = { Text(text = title) },
            supportingContent = { Text(text = description) },
            trailingContent = {
                Icon(imageVector = Icons.Rounded.KeyboardArrowRight, contentDescription = null)
            }
        )

        Divider(
            thickness = .5.dp,
            color = Color.LightGray
        )
    }
}

@Composable
fun ServiceItemComponent(
    icon: ImageVector,
    title: String,
    enabled: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { if (enabled) onClick() }
    ) {

        ListItem(
            leadingContent = { Icon(imageVector = icon, contentDescription = title) },
            headlineContent = { Text(text = title) },
            trailingContent = {
                Icon(imageVector = Icons.Rounded.KeyboardArrowRight, contentDescription = null)
            }
        )

        Divider(
            thickness = .5.dp,
            color = Color.LightGray
        )
    }
}