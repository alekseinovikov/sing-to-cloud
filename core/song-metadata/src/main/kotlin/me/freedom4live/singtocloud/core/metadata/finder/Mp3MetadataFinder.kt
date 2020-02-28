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

    private val genreHeader = "genre"
    private val albumHeader = "album"
    private val artistHeader = "artist"
    private val titleHeader = "title"
    private val creatorHeader = "creator"

    override fun supports() = MediaType.MP3

    override fun find(file: File): SongMetadata {
        val metadata = FileInputStream(file).use { stream ->
            Mp3Metadata().also { parser.parse(stream, handler, it, context) }
        }

        val genre = getMetadataFromHeaderSubstring(metadata, genreHeader)
        val album = getMetadataFromHeaderSubstring(metadata, albumHeader)
        val artist = getMetadataFromHeaderSubstring(metadata, artistHeader)
        val title = getMetadataFromHeaderSubstring(metadata, titleHeader)
        val creator = getMetadataFromHeaderSubstring(metadata, creatorHeader)

        return SongMetadata(
                title = title,
                artist = artist,
                genre = genre,
                album = album,
                creator = creator)
    }

    private fun getMetadataFromHeaderSubstring(metadata: Mp3Metadata, header: String) =
            metadata.names().first { it.contains(header, ignoreCase = true) }?.let { key -> metadata[key] }

}
