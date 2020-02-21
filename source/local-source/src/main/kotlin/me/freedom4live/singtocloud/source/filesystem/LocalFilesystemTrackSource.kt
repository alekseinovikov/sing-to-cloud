package me.freedom4live.singtocloud.source.filesystem

import me.freedom4live.singtocloud.source.api.TrackSource
import me.freedom4live.singtocloud.source.api.TrackSourceType
import me.freedom4live.singtocloud.source.api.model.FileSystemTrackRequest
import me.freedom4live.singtocloud.source.api.model.TrackMetaData
import me.freedom4live.singtocloud.source.api.model.TrackRequest
import me.freedom4live.singtocloud.source.filesystem.helpers.FileHelper
import me.freedom4live.singtocloud.source.filesystem.reader.ContentReader
import java.io.File
import java.nio.file.Files
import kotlin.streams.asSequence
import kotlin.streams.toList

internal class LocalFilesystemTrackSource(private val contentReader: ContentReader) : TrackSource {

    override fun findTracks(trackRequest: TrackRequest): List<TrackMetaData> {
        if (trackRequest !is FileSystemTrackRequest) throw IllegalArgumentException("Unsupported request type!")

        val rootDirectory = trackRequest.dirPath.run { FileHelper.getDirectory(this) }
        return Files.walk(rootDirectory.toPath())
                .filter { Files.isDirectory(it).not() && Files.isReadable(it) }
                .map { contentReader.readMetadataIfPossible(File(it.toUri())) }
                .asSequence()
                .filterNotNull()
                .toList()

    }

    override fun supports() = TrackSourceType.FILESYSTEM

}