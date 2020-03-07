package me.freedom4live.singtocloud.application.frontend.javafx.impl.config

import me.freedom4live.singtocloud.application.frontend.javafx.impl.source.SourceManagerImpl
import me.freedom4live.singtocloud.source.api.TrackSource
import me.freedom4live.singtocloud.translation.translator.Translator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class JavaFxConfiguration {

    @Bean
    fun sourceManager(trackSources: List<TrackSource>, translator: Translator) = SourceManagerImpl(trackSources, translator)

}
