package com.github.codeideal.v2explugin.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import coil3.ImageLoader
import coil3.asCoilImage
import coil3.compose.setSingletonImageLoaderFactory
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import coil3.util.DebugLogger
import com.github.codeideal.v2explugin.koin.*
import com.github.codeideal.v2explugin.ui.page.SamplePage
import com.github.codeideal.v2explugin.ui.theme.AppTheme
import com.github.codeideal.v2explugin.util.loadBitmap
import org.koin.compose.KoinIsolatedContext

/**
 * @program: v2exPlugin
 *
 * @description: sample of compose UI in IntelliJ plugin tool windows
 *
 * @author: kangyang
 *
 * @create: 2023/12/27 19:18
 **/
@Composable
fun App() {
    KoinIsolatedContext(context = IsolateInjectContext.koinApp) {
        // coil init
        val placeHolderBitmap = remember { loadBitmap("pics/placeHolder.png") }
        setSingletonImageLoaderFactory { context ->
            ImageLoader.Builder(context)
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
        AppTheme{
            SamplePage()
        }
    }
}