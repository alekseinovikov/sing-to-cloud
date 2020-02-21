package me.freedom4live.singtocloud.source.filesystem.reader

import me.freedom4live.singtocloud.source.api.model.TrackMetaData
import java.io.File

internal interface ContentReader {
    fun readMetadataIfPossible(file: File): TrackMetaData?
}