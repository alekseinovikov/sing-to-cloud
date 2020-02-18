package me.freedom4live.singtocloud.application.fx.runner.impl

import javafx.stage.Stage
import me.freedom4live.singtocloud.application.frontend.javafx.api.SceneManager
import me.freedom4live.singtocloud.application.fx.config.FxWindowProperties
import me.freedom4live.singtocloud.application.fx.runner.JavaFxApplicationRunner
import org.springframework.stereotype.Component

@Component
internal class JavaFxApplicationRunnerImpl(private val sceneManager: SceneManager,
                                           private val windowProperties: FxWindowProperties) : JavaFxApplicationRunner {

    override fun run(stage: Stage) {
        sceneManager.init(stage)

        with(windowProperties) {
            title?.let { stage.title = it }
            width?.let { stage.minWidth = it }
            height?.let { stage.minHeight = it }

            stage.isResizable = isResizable

            if (isCentralizedOnScreen) stage.centerOnScreen()
        }

        stage.show()
    }

}