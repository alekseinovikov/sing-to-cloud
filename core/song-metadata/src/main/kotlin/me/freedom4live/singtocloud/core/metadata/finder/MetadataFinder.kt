package me.freedom4live.singtocloud.core.metadata.finder

import me.freedom4live.singtocloud.core.mediatype.MediaType
import me.freedom4live.singtocloud.core.metadata.SongMetadata
import java.io.File

internal interface MetadataFinder {
    fun supports(): MediaType
    fun find(file: File): SongMetadata
}
