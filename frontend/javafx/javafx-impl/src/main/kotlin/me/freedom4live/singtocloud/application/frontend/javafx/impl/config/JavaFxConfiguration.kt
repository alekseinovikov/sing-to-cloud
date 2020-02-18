package me.freedom4live.singtocloud.application.frontend.javafx.impl.config

import me.freedom4live.singtocloud.application.frontend.javafx.impl.SceneManagerImpl
import me.freedom4live.singtocloud.application.frontend.javafx.impl.stages.MainStage
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JavaFxConfiguration {

    @Bean
    internal fun sceneManager(mainStage: MainStage) = SceneManagerImpl(mainStage)

    @Bean
    internal fun fxStageBeanPostProcessor() = FxStageBeanPostProcessor()

    @Bean
    internal fun mainStage() = MainStage()

}
