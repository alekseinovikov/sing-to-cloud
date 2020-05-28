package me.freedom4live.singtocloud.core.source.impl

import me.freedom4live.singtocloud.core.source.SourceData
import me.freedom4live.singtocloud.core.source.SourceProvider
import me.freedom4live.singtocloud.core.source.TrackSource
import me.freedom4live.singtocloud.core.translate.Translator
import org.springframework.stereotype.Component

@Component
internal class SourceProviderImpl(private val translator: Translator) : SourceProvider {

    override fun getAllSupportedSources(): List<SourceData> = TrackSource.values().map {
        val translation = translator.getTranslation(it.name) ?: it.name
        SourceData(it, translation)
    }

}