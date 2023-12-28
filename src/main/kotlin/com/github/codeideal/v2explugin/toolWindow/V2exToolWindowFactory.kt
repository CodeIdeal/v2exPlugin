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

    init {
        // from `Jewel` project tips. See: https://github.com/JetBrains/jewel?tab=readme-ov-file#swing-interoperability
        // https://blog.jetbrains.com/kotlin/2023/08/compose-multiplatform-1-5-0-release/#enhanced-swing-interop
        System.setProperty("compose.swing.render.on.graphics", "true")
    }

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
