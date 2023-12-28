package com.github.codeideal.v2explugin.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.codeideal.v2explugin.services.V2exService
import com.github.codeideal.v2explugin.ui.theme.AppTheme

/**
 * @program: v2exPlugin
 *
 * @description: sample of compose UI in IntelliJ plugin tool windows
 *
 * @author: kangyang
 *
 * @create: 2023/12/27 19:18
 **/
@Suppress("FunctionName")
@Composable
fun App(service: V2exService) {
    AppTheme{
        Box(contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                var count by remember { mutableStateOf(0) }
                Text("Count: $count")
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { count = service.getRandomNumber() }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add"
                    )
                    Text("Hello JetBrains!")
                }
            }

        }
    }
}