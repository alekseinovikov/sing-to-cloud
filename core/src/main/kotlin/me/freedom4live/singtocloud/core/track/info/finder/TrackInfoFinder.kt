package me.freedom4live.singtocloud.core.track.info.finder

import me.freedom4live.singtocloud.core.mediatype.MediaType
import me.freedom4live.singtocloud.core.track.info.TrackInfo
import java.io.File

internal interface TrackInfoFinder {
    fun supports(): MediaType
    fun find(file: File): TrackInfo
}
