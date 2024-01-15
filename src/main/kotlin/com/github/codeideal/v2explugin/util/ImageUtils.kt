@file:Suppress("UnstableApiUsage")

package com.github.codeideal.v2explugin.util

import androidx.compose.ui.graphics.asSkiaBitmap
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import com.github.codeideal.v2explugin.toolWindow.V2exToolWindowFactory
import org.jetbrains.skia.Bitmap
import org.jetbrains.skia.Image


/**
 * @program: Plugin
 *
 * @description: image utils
 *
 * @author: kangyang
 *
 * @create: 2024/1/6 23:56
 **/
fun loadImage(path: String): Image {
    Thread.currentThread().contextClassLoader = V2exToolWindowFactory::class.java.classLoader
    val bitmap = useResource(path){ loadImageBitmap(it) }
    return Image.makeFromBitmap(bitmap.asSkiaBitmap())
}

fun loadBitmap(path: String): Bitmap {
    // See: https://github.com/JetBrains/compose-multiplatform/issues/618
    Thread.currentThread().contextClassLoader = V2exToolWindowFactory::class.java.classLoader
    return useResource(path){ loadImageBitmap(it).asSkiaBitmap() }
}