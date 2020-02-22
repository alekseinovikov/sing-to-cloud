package me.freedom4live.singtocloud.source.filesystem

import me.freedom4live.singtocloud.source.api.TrackSourceType
import me.freedom4live.singtocloud.source.api.model.EmptyTrackRequest
import me.freedom4live.singtocloud.source.api.model.FileSystemFileInfo
import me.freedom4live.singtocloud.source.api.model.FileSystemTrackRequest
import me.freedom4live.singtocloud.source.api.model.TrackResponse
import me.freedom4live.singtocloud.source.filesystem.reader.ContentReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.io.File
import java.net.URL

@ExtendWith(MockitoExtension::class)
internal class LocalFilesystemTrackSourceTest {

    @Mock
    private lateinit var contentReader: ContentReader

    @InjectMocks
    private lateinit var trackSource: LocalFilesystemTrackSource

    @Test
    fun supportsShouldReturnFilesystem() {
        //act
        val result = trackSource.supports()

        //assert
        Assertions.assertEquals(TrackSourceType.FILESYSTEM, result)
    }

    @Test
    fun findTracksWrongTypeIllegalArgumentException() {
        //arrange
        val request = EmptyTrackRequest

        //act
        Assertions.assertThrows(IllegalArgumentException::class.java) { trackSource.findTracks(request) }
    }

    @Test
    fun findTracksDirectoryWithNoFilesReturnsEmptyList() {
        //arrange
        val resource = getResource("empty_dir")
        val request = FileSystemTrackRequest(resource.path)

        //act
        val result = trackSource.findTracks(request)

        //assert
        Assertions.assertTrue(result.isEmpty())
    }

    @Test
    fun findTracksDirectoryWithTextFileCallsContentReader() {
        //arrange
        val resource = getResource("text_dir")
        val request = FileSystemTrackRequest(resource.path)

        val textFileURL = getResource("text_dir/text.txt")
        val file = File(textFileURL.toURI())

        //act
        trackSource.findTracks(request)

        //assert
        Mockito.verify(contentReader).readMetadataIfPossible(file)
    }

    @Test
    fun findTracksDirectoryWithTwoFilesReturnsResultFromContentReader() {
        //arrange
        val directoryURL = getResource("two_files_dir")
        val firstFileURL = getResource("two_files_dir/1.txt")
        val secondFileURL = getResource("two_files_dir/2.txt")

        val firstFile = File(firstFileURL.toURI())
        val secondFile = File(secondFileURL.toURI())

        val firstTrackInfo = TrackResponse(1L, null, FileSystemFileInfo("1.txt", firstFileURL.path))
        val secondTrackInfo = TrackResponse(2L, null, FileSystemFileInfo("2.txt", secondFileURL.path))

        Mockito.`when`(contentReader.readMetadataIfPossible(firstFile)).thenReturn(firstTrackInfo)
        Mockito.`when`(contentReader.readMetadataIfPossible(secondFile)).thenReturn(secondTrackInfo)

        val request = FileSystemTrackRequest(directoryURL.path)

        //act
        val result = trackSource.findTracks(request)

        //assert
        Assertions.assertFalse(result.isEmpty())
        Assertions.assertEquals(2, result.size)

        Assertions.assertEquals(firstTrackInfo, result[0])
        Assertions.assertEquals(secondTrackInfo, result[1])
    }

    private fun getResource(filePath: String): URL {
        return when (val url = this.javaClass.classLoader.getResource(filePath)) {
            null -> {
                println("CAN'T FIND THE FILE: $filePath")
                throw IllegalArgumentException("Can't find file: $filePath")
            }
            else -> url
        }
    }
}
