package me.freedom4live.singtocloud.application.frontend.javafx.impl.source

import me.freedom4live.singtocloud.source.api.TrackSourceType

internal interface SourceManager {
    fun supports(): List<TrackSourceType>
    fun getTitle(trackSourceType: TrackSourceType): String
}
