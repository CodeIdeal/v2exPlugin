package com.github.codeideal.v2explugin.intellij.listeners

import com.github.codeideal.v2explugin.koin.IsolateInjectContext
import com.intellij.ide.AppLifecycleListener
import com.intellij.openapi.diagnostic.thisLogger
import org.koin.core.context.startKoin

/**
 * @program: Plugin
 *
 * @description:
 *
 * @author: kangyang
 *
 * @create: 2023/12/31 02:51
 **/
class PluginAppLifecycleListener: AppLifecycleListener {
    override fun appFrameCreated(commandLineArgs: MutableList<String>) {
        super.appFrameCreated(commandLineArgs)
        thisLogger().info("appFrameCreated!")
        startKoin(IsolateInjectContext.koinApp)
    }
}