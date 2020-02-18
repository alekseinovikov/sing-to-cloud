package me.freedom4live.singtocloud.application.fx

import javafx.application.Application
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext

internal abstract class JavaFxSupport : Application() {

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
