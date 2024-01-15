package com.github.codeideal.v2explugin.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.ImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.asCoilImage
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.compose.setSingletonImageLoaderFactory
import coil3.fetch.NetworkFetcher
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.util.DebugLogger
import com.github.codeideal.v2explugin.koin.IsolateInjectContext
import com.github.codeideal.v2explugin.koin.V2exService
import com.github.codeideal.v2explugin.ui.theme.AppTheme
import com.github.codeideal.v2explugin.util.loadBitmap
import com.github.codeideal.v2explugin.widget.ResImage
import org.koin.compose.KoinIsolatedContext
import org.koin.compose.koinInject

/**
 * @program: Plugin
 *
 * @description: compose sample
 *
 * @author: kangyang
 *
 * @create: 2024/1/7 02:34
 **/
@Suppress("FunctionName")
@OptIn(ExperimentalCoilApi::class)
@Composable
fun AppSample(v2exService: V2exService = koinInject()) {
    val placeHolderBitmap = remember { loadBitmap("pics/placeHolder.png") }
    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context)
            .components {
                add(NetworkFetcher.Factory())
            }
            .placeholder(placeHolderBitmap.asCoilImage())
            .diskCachePolicy(CachePolicy.DISABLED)
            .memoryCache {
                MemoryCache.Builder()
                    // Set the max size to 25% of the app's available memory.
                    .maxSizePercent(context, percent = 0.25)
                    .build()
            }
            // Show a short crossfade when loading images asynchronously.
            .crossfade(true)
            // Enable logging if this is a debug build.
            .apply {
                if (true) {
                    logger(DebugLogger())
                }
            }
            .build()
    }
    KoinIsolatedContext(context = IsolateInjectContext.koinApp) {
        AppTheme {
            Box(contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    var randomInt by remember { mutableStateOf(0) }
                    Text("Random: $randomInt")
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = { randomInt = v2exService.getRandomInt(10) }) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Refresh"
                        )
                        Text("Next Int")
                    }
                    AsyncImage(
                        model = ImageRequest.Builder(LocalPlatformContext.current)
                            .data("https://www.bing.com/th?id=OHR.DevilsMarbles_ZH-CN4897809914_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp")
                            .build(),
                        contentDescription = null,
                        modifier = Modifier.width(160.dp).height(160.dp).border(2.dp, Color.Red),
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ResImage(
                        resPath = "pics/placeHolder.png",
                        contentDescription = null,
                        modifier = Modifier.width(160.dp).height(160.dp).border(2.dp, Color.Red),
                    )
                }
            }
        }
    }
}