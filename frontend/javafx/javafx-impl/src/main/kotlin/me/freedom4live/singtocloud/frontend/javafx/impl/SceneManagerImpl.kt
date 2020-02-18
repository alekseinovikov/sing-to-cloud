package me.freedom4live.singtocloud.frontend.javafx.impl

import javafx.stage.Window
import me.freedom4live.singtocloud.frontend.javafx.api.SceneManager

internal class SceneManagerImpl : SceneManager {

    private lateinit var rootWindow: Window

    override fun init(window: Window) {
        rootWindow = window
    }
}