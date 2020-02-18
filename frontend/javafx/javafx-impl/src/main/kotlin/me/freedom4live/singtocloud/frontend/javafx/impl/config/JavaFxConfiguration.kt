package me.freedom4live.singtocloud.frontend.javafx.impl.config

import me.freedom4live.singtocloud.frontend.javafx.impl.SceneManagerImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JavaFxConfiguration {

    @Bean
    internal fun sceneManager() = SceneManagerImpl()

}