package me.freedom4live.singtocloud.application.frontend.javafx.impl

import javafx.stage.Stage
import me.freedom4live.singtocloud.application.frontend.javafx.api.SceneManager

internal class SceneManagerImpl : SceneManager {

    private lateinit var rootWindow: Stage

    override fun init(window: Stage) {
        rootWindow = window
    }

}