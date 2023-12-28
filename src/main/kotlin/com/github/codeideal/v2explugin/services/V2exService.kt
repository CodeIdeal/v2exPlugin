package com.github.codeideal.v2explugin.services

import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.github.codeideal.v2explugin.PluginBundle

@Service(Service.Level.PROJECT)
class V2exService(project: Project) {

    init {
        thisLogger().info(PluginBundle.message("projectService", project.name))
    }

    fun getRandomNumber() = (1..100).random()
}
