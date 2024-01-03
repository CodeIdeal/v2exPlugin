package com.github.codeideal.v2explugin.listeners

import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowManager
import com.intellij.openapi.wm.ex.ToolWindowManagerListener

/**
 * @program: Plugin
 *
 * @description: Project open Listener
 *
 * @author: kangyang
 *
 * @create: 2024/1/2 11:38
 **/
class ToolWindowListener: ToolWindowManagerListener {
    override fun toolWindowsRegistered(ids: MutableList<String>, toolWindowManager: ToolWindowManager) {
        super.toolWindowsRegistered(ids, toolWindowManager)
        thisLogger().info("toolWindowsRegistered, $ids, $toolWindowManager")
    }

    override fun toolWindowUnregistered(id: String, toolWindow: ToolWindow) {
        super.toolWindowUnregistered(id, toolWindow)
        thisLogger().info("toolWindowUnregistered, $id, $toolWindow")
    }

    override fun stateChanged(toolWindowManager: ToolWindowManager) {
        super.stateChanged(toolWindowManager)
        thisLogger().info("stateChanged, $toolWindowManager")
    }

    override fun stateChanged(
        toolWindowManager: ToolWindowManager,
        changeType: ToolWindowManagerListener.ToolWindowManagerEventType
    ) {
        super.stateChanged(toolWindowManager, changeType)
        thisLogger().info("stateChanged, $toolWindowManager, $changeType")
    }

    override fun toolWindowShown(toolWindow: ToolWindow) {
        super.toolWindowShown(toolWindow)
        thisLogger().info("toolWindowShown, ${toolWindow.id}")
    }
}