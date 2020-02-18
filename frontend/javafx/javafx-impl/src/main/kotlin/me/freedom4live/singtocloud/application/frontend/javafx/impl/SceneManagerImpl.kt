package me.freedom4live.singtocloud.application.frontend.javafx.impl

import javafx.stage.Window
import me.freedom4live.singtocloud.application.frontend.javafx.api.SceneManager

internal class SceneManagerImpl : SceneManager {

    private lateinit var rootWindow: Window

    override fun init(window: Window) {
        rootWindow = window
    }
}