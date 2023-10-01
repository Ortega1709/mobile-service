package com.ortega.services.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.ortega.services.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    title: String,
    onClickNavigation: () -> Unit,
    actions: @Composable() (RowScope.() -> Unit),
    scrollBehavior: TopAppBarScrollBehavior?
) {

    MediumTopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            scrolledContainerColor = MaterialTheme.colorScheme.background
        ),
        actions = actions,
        navigationIcon = {
            IconButton(onClick = onClickNavigation) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = stringResource(R.string.back)
                )
            }
        },
        scrollBehavior = scrollBehavior,
        title = { Text(text = title) }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    title: String,
    scrollBehavior: TopAppBarScrollBehavior?
) {

    MediumTopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            scrolledContainerColor = MaterialTheme.colorScheme.background
        ),
        scrollBehavior = scrollBehavior,
        title = { Text(text = title) }
    )

}