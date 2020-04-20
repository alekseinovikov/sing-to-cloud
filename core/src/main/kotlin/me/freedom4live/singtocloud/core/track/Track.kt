package me.freedom4live.singtocloud.core.track

import me.freedom4live.singtocloud.core.track.info.TrackInfo
import java.util.*

typealias TrackId = String

data class Track(val sourceInfo: TrackSourceInfo,
                 val info: TrackInfo) {
    val id: TrackId = UUID.randomUUID().toString()
}
