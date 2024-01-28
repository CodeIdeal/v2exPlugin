package com.github.codeideal.v2explugin.intellij.toolWindow

import androidx.compose.ui.awt.ComposePanel
import com.github.codeideal.v2explugin.ui.App
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import com.intellij.openapi.diagnostic.thisLogger


class V2exToolWindowFactory : ToolWindowFactory {

    init {
        // from `Jewel` project tips. See: https://github.com/JetBrains/jewel?tab=readme-ov-file#swing-interoperability
        // https://blog.jetbrains.com/kotlin/2023/08/compose-multiplatform-1-5-0-release/#enhanced-swing-interop
        System.setProperty("compose.swing.render.on.graphics", "true")
    }

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        thisLogger().info("createToolWindowContent: ${project.name}")
        val content = ContentFactory.getInstance().createContent(getComposeComponent(), null, false)
        toolWindow.contentManager.addContent(content)
    }

    private fun getComposeComponent() = ComposePanel().apply { setContent { App() } }

    override fun shouldBeAvailable(project: Project) = true
}
