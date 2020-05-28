package me.freedom4live.singtocloud.core.translate.impl

import me.freedom4live.singtocloud.core.source.TrackSource
import me.freedom4live.singtocloud.core.translate.Translator
import org.springframework.stereotype.Component

@Component
internal class TranslatorImpl : Translator {

    //TODO: Implement correct way from resources etc
    private val placeholderMap = mapOf(TrackSource.FILE_SYSTEM.name to "File system")


    override fun getTranslation(placeholder: String): String? = placeholderMap[placeholder]

}