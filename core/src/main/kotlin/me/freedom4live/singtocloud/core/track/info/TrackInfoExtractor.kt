package me.freedom4live.singtocloud.core.track.info

import me.freedom4live.singtocloud.core.mediatype.MediaType
import me.freedom4live.singtocloud.core.mediatype.MediaTypeDetector
import me.freedom4live.singtocloud.core.track.info.finder.TrackInfoFinder
import me.freedom4live.singtocloud.core.track.info.finder.Mp3TrackInfoFinder
import java.io.File

object TrackInfoExtractor {
    private val mediaTypeDetector = MediaTypeDetector
    private val TRACK_INFO_FINDER_MAP: Map<MediaType, TrackInfoFinder> = mapOf(MediaType.MP3 to Mp3TrackInfoFinder)

    fun extract(file: File): TrackInfo? = mediaTypeDetector.detect(file).let { mediaType ->
        return when (val trackInfoFinder = TRACK_INFO_FINDER_MAP[mediaType]) {
            null -> null
            else -> trackInfoFinder.find(file)
        }
    }

}
