package me.freedom4live.singtocloud

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import me.freedom4live.singtocloud.fx.JavaFxSupport
import me.freedom4live.singtocloud.fx.controller.LoginController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class JavaFxApplication : JavaFxSupport() {

    @Autowired
    lateinit var loginController: LoginController

    override fun start(stage: Stage) {
        stage.title = "Sing To Cloud"

        stage.scene = Scene(loginController.rootView)

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
