package me.freedom4live.singtocloud.translation.config

import me.freedom4live.singtocloud.translation.translator.impl.TranslatorImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class TranslatorConfiguration {

    @Bean
    fun translator() = TranslatorImpl()

}
