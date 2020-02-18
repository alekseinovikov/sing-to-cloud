package me.freedom4live.singtocloud.application.fx

import javafx.application.Application
import javafx.stage.Stage
import me.freedom4live.singtocloud.application.fx.runner.JavaFxApplicationRunner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
internal class JavaFxApplication : JavaFxSupport() {

    @Autowired
    private lateinit var applicationRunner: JavaFxApplicationRunner

    override fun start(stage: Stage) = applicationRunner.run(stage)

}

fun main(args: Array<String>) {
    Application.launch(JavaFxApplication::class.java, *args)
}
