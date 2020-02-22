package me.freedom4live.singtocloud.source.filesystem.reader

import me.freedom4live.singtocloud.source.api.model.TrackResponse
import java.io.File

internal interface ContentReader {
    fun readMetadataIfPossible(file: File): TrackResponse?
}
