package me.freedom4live.singtocloud.source.filesystem.reader.impl

import me.freedom4live.singtocloud.source.api.model.FileSystemFileInfo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension
import java.io.File

@ExtendWith(MockitoExtension::class)
internal class ContentReaderImplTest {

    @InjectMocks
    private lateinit var contentReader: ContentReaderImpl


    @Test
    fun readMetadataIfPossibleMp3FileReturnsAllTheMetadataAndFileInfo() {
        //arrange
        val fileURL = this.javaClass.classLoader.getResource("mp3_sample.mp3")!!
        val file = File(fileURL.toURI())

        //act
        val result = contentReader.readMetadataIfPossible(file)

        //assert
        Assertions.assertNotNull(result)
        result!!
        Assertions.assertNotNull(result.id)
        Assertions.assertEquals(result.fileInfo.fileName, "mp3_sample.mp3")
        Assertions.assertEquals(result.fileInfo.javaClass, FileSystemFileInfo::class.java)
        Assertions.assertEquals((result.fileInfo as FileSystemFileInfo).filePath, file.path)

        val metaData = result.metaData!!
        Assertions.assertEquals("Cinematic", metaData.genre)
        Assertions.assertEquals("YouTube Audio Library", metaData.album)
        Assertions.assertEquals("Kevin MacLeod", metaData.artist)
        Assertions.assertEquals("Impact Moderato", metaData.title)
        Assertions.assertEquals("Kevin MacLeod", metaData.creator)
    }

    @Test
    fun readMetadataIfPossibleTxtFileReturnsFileInfoOnly() {
        //arrange
        val fileURL = this.javaClass.classLoader.getResource("text.txt")!!
        val file = File(fileURL.toURI())

        //act
        val result = contentReader.readMetadataIfPossible(file)

        //assert
        Assertions.assertNotNull(result)
        result!!
        Assertions.assertNotNull(result.id)
        Assertions.assertEquals(result.fileInfo.fileName, "text.txt")
        Assertions.assertEquals(result.fileInfo.javaClass, FileSystemFileInfo::class.java)
        Assertions.assertEquals((result.fileInfo as FileSystemFileInfo).filePath, file.path)

        Assertions.assertNull(result.metaData)
    }

}
