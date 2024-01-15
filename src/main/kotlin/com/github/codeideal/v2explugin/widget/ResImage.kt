package com.github.codeideal.v2explugin.widget

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asComposeImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import com.github.codeideal.v2explugin.util.loadBitmap
import com.intellij.openapi.diagnostic.thisLogger

@Suppress("FunctionName")
@Composable
fun ResImage(
    resPath:String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
){
    var state by remember { mutableStateOf<LoadState>(LoadState.Loading) }

    LaunchedEffect(resPath){
        val image = try{
            loadBitmap(resPath).asComposeImageBitmap()
        } catch (e: Exception){
            thisLogger().error(e)
            null
        }

        state = image?.let { LoadState.Success(it) } ?: LoadState.Fail
    }

    when(state){
        is LoadState.Loading -> {
            val infiniteTransition = rememberInfiniteTransition()
            val degree by infiniteTransition.animateFloat(0f,360f, infiniteRepeatable(
                animation = tween(1000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            ))
            Icon(imageVector = Icons.Default.Refresh, contentDescription = contentDescription, modifier = modifier.graphicsLayer(rotationZ = degree))
        }
        is LoadState.Success -> (state as? LoadState.Success)?.bitmap?.let { Image(bitmap = it, contentDescription = contentDescription, modifier = modifier) }
        is LoadState.Fail -> Icon(imageVector = Icons.Default.Warning, contentDescription = contentDescription, modifier = modifier)
    }

}

sealed class LoadState{
    data object Loading:LoadState()
    class Success(val bitmap: ImageBitmap):LoadState()
    data object Fail : LoadState()
}