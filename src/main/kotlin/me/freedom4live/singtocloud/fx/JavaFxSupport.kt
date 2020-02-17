package me.freedom4live.singtocloud.fx

import javafx.application.Application
import me.freedom4live.singtocloud.JavaFxApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext

abstract class JavaFxSupport : Application() {

    protected lateinit var context: ConfigurableApplicationContext

    override fun init() {
        context = runApplication<JavaFxApplication>() {
            setHeadless(false)
        }.also {
            it.autowireCapableBeanFactory.autowireBean(this)
        }
    }

    override fun stop() {
        context.close()
    }

}
