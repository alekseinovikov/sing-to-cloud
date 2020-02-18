package me.freedom4live.singtocloud

import javafx.application.Application
import javafx.stage.Stage
import me.freedom4live.singtocloud.frontend.javafx.api.SceneManager
import me.freedom4live.singtocloud.fx.JavaFxSupport
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class JavaFxApplication : JavaFxSupport() {

    @Autowired
    private lateinit var sceneManager: SceneManager

    override fun start(stage: Stage) {
        stage.title = "Sing To Cloud"

        sceneManager.init(stage)

        stage.minWidth = 640.0
        stage.minHeight = 480.0

        stage.isResizable = true
        stage.centerOnScreen()
        stage.show()
    }

}

fun main(args: Array<String>) {
    Application.launch(JavaFxApplication::class.java, *args)
}
