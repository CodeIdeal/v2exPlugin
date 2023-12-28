package com.github.codeideal.v2explugin.toolWindow

import androidx.compose.ui.awt.ComposePanel
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import com.github.codeideal.v2explugin.services.V2exService
import com.github.codeideal.v2explugin.ui.App


class V2exToolWindowFactory : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val myToolWindow = MyToolWindow(toolWindow)
        val content = ContentFactory.getInstance().createContent(myToolWindow.getContent(), null, false)
        toolWindow.contentManager.addContent(content)
    }

    override fun shouldBeAvailable(project: Project) = true

    class MyToolWindow(toolWindow: ToolWindow) {

        private val service = toolWindow.project.service<V2exService>()

        fun getContent() = ComposePanel().apply {
            setContent {
                App(service)
            }
        }
    }
}
