package com.github.codeideal.v2explugin.ui.page

import androidx.compose.animation.fadeIn
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import com.github.codeideal.v2explugin.koin.V2exService
import com.github.codeideal.v2explugin.ui.widget.BasePage
import com.github.codeideal.v2explugin.ui.widget.ResImage
import com.github.codeideal.v2explugin.util.loadResBytes
import org.koin.compose.koinInject

/**
 * @program: ComposeTest
 *
 * @description: For components test or sample page
 *
 * @author: kangyang
 *
 * @create: 2024/1/26 18:56
 **/
@Composable
fun SamplePage(){
    BasePage(showBack = false) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(8.dp))
            RandomSample()

            Spacer(modifier = Modifier.height(16.dp))
            Text("# Coil Load Net Image")
            AsyncImage(
                model = ImageRequest.Builder(LocalPlatformContext.current)
                    .data("https://www.bing.com/th?id=OHR.DevilsMarbles_ZH-CN4897809914_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp")
                    .build(),
                contentDescription = null,
                modifier = Modifier.width(160.dp).height(160.dp).border(2.dp, Color.Red),
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text("# Coil Load Local Image")
            AsyncImage(
                model = ImageRequest.Builder(LocalPlatformContext.current)
                    .data(loadResBytes("pics/placeHolder.svg"))
                    .build(),
                contentDescription = null,
                modifier = Modifier.width(160.dp).height(160.dp).border(2.dp, Color.Red),
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text("# ResImage Load Local Image")
            ResImage(
                resPath = "pics/placeHolder.png",
                contentDescription = null,
                modifier = Modifier.width(160.dp).height(160.dp).border(2.dp, Color.Red),
            )
        }
    }
}

/**
 * Random sample
 * Extraction a @Composable method can reduce ReCompose Scope
 *
 * @param v2exService
 */
@Composable
fun RandomSample(v2exService: V2exService = koinInject()) {
    var randomInt by remember { mutableStateOf(0) }
    Text("# Random: $randomInt")
    Button(onClick = { randomInt = v2exService.getRandomInt(10) }) {
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = "Refresh"
        )
        Text("Next Int")
    }
}
