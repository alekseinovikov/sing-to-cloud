package me.freedom4live.singtocloud.core.metadata.finder

import me.freedom4live.singtocloud.core.mediatype.MediaType
import me.freedom4live.singtocloud.core.metadata.SongMetadata
import org.apache.tika.parser.ParseContext
import org.apache.tika.parser.mp3.Mp3Parser
import org.xml.sax.helpers.DefaultHandler
import java.io.File
import java.io.FileInputStream

internal typealias Mp3Metadata = org.apache.tika.metadata.Metadata

internal object Mp3MetadataFinder : MetadataFinder {
    private val parser = Mp3Parser()
    private val context = ParseContext()
    private val handler = DefaultHandler()

    override fun supports() = MediaType.MP3

    override fun find(file: File): SongMetadata {
        val metadata = FileInputStream(file).use { stream ->
            val mp3Metadata = Mp3Metadata()

            parser.parse(stream, handler, mp3Metadata, context)
            mp3Metadata
        }

        return SongMetadata(null, null, null, null, null)
    }

}
