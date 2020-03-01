package me.freedom4live.singtocloud.source.filesystem.reader.impl

import me.freedom4live.singtocloud.core.metadata.SongMetadataExtractor
import me.freedom4live.singtocloud.id.Id
import me.freedom4live.singtocloud.id.generate
import me.freedom4live.singtocloud.source.api.model.FileSystemFileInfo
import me.freedom4live.singtocloud.source.api.model.TrackMetaData
import me.freedom4live.singtocloud.source.api.model.TrackResponse
import me.freedom4live.singtocloud.source.filesystem.reader.ContentReader
import java.io.File

internal class ContentReaderImpl : ContentReader {

    private val metadataExtractor = SongMetadataExtractor

    override fun readMetadataIfPossible(file: File): TrackResponse? = when (file.canRead().not()) {
        true -> null
        false -> extractMetadata(file)
    }

    private fun extractMetadata(file: File): TrackResponse {
        val trackMetadata = extractSongMetadata(file)
        val fileInfo = extractFileInfo(file)

        val id = Id::class.generate()
        return TrackResponse(
                id = id,
                metaData = trackMetadata,
                fileInfo = fileInfo)
    }

    private fun extractSongMetadata(file: File) = metadataExtractor.extract(file)?.let {
        TrackMetaData(title = it.title, genre = it.genre,
                album = it.album, artist = it.artist, creator = it.creator)
    }

    private fun extractFileInfo(file: File): FileSystemFileInfo {
        val name = file.name
        val path = file.path

        return FileSystemFileInfo(name = name, filePath = path)
    }

}
