package me.freedom4live.singtocloud.core.metadata

import me.freedom4live.singtocloud.core.mediatype.MediaType
import me.freedom4live.singtocloud.core.mediatype.MediaTypeDetector
import me.freedom4live.singtocloud.core.metadata.finder.MetadataFinder
import me.freedom4live.singtocloud.core.metadata.finder.Mp3MetadataFinder
import java.io.File

object SongMetadataExtractor {
    private val mediaTypeDetector = MediaTypeDetector
    private val metadataFinderMap: Map<MediaType, MetadataFinder> = mapOf(MediaType.MP3 to Mp3MetadataFinder)

    fun extract(file: File): SongMetadata? = mediaTypeDetector.detect(file).let { mediaType ->
        return when (val metadataFinder = metadataFinderMap[mediaType]) {
            null -> null
            else -> metadataFinder.find(file)
        }
    }

}
