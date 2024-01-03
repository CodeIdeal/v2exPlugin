package com.github.codeideal.v2explugin.koin

import org.koin.dsl.koinApplication
import org.koin.dsl.module

/**
 * @program: Plugin
 *
 * @description: Isolated koin inject context
 *
 * @author: kangyang
 *
 * @create: 2023/12/31 01:13
 **/
object IsolateInjectContext {
    val koinApp = koinApplication {
        // v2ex module
        val v2exModule = module{
            single{ V2exService() }
        }

        // declare app modules
        modules(v2exModule)
    }
}