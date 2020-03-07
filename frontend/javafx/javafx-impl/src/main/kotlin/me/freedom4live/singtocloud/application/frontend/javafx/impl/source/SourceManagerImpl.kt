package me.freedom4live.singtocloud.application.frontend.javafx.impl.source

import me.freedom4live.singtocloud.source.api.TrackSource
import me.freedom4live.singtocloud.source.api.TrackSourceType
import me.freedom4live.singtocloud.translation.translator.Translator

internal class SourceManagerImpl(private val trackSources: List<TrackSource>,
                                 private val translator: Translator) : SourceManager {

    override fun supports(): List<TrackSourceType> = trackSources.map { it.supports() }

    override fun getTitle(trackSourceType: TrackSourceType) = translator.resolve(trackSourceType.titlePlaceHolder)

}
