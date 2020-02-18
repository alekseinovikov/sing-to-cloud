package me.freedom4live.singtocloud.application.frontend.javafx.impl

import javafx.scene.Scene
import javafx.stage.Stage
import me.freedom4live.singtocloud.application.frontend.javafx.api.SceneManager
import me.freedom4live.singtocloud.application.frontend.javafx.impl.stages.MainStage

internal class SceneManagerImpl(private val stage: MainStage) : SceneManager {

    private lateinit var rootWindow: Stage

    override fun init(window: Stage) {
        rootWindow = window

        rootWindow.scene = Scene(stage.stage)
    }
}
