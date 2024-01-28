package com.github.codeideal.v2explugin.ui.widget

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * @program: ComposeTest
 *
 * @description: Define universal basic page structure
 *
 * @author: kangyang
 *
 * @create: 2024/1/26 18:39
 **/
@Composable
fun BasePage(
    title: String? = null,
    showBack: Boolean = true,
    modifier: Modifier = Modifier,
    content:@Composable () -> Unit
) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column {
            TopAppBar{
                if(showBack) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                    )
                }
                Spacer(modifier = Modifier.weight(weight = 1f))
                title?.let { Text(it) }
                Spacer(modifier = Modifier.weight(weight = 1f))
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                )
            }
            content()
        }
    }
}