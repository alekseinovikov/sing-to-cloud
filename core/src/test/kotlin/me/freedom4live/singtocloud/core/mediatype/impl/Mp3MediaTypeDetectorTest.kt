package me.freedom4live.singtocloud.core.mediatype.impl

import me.freedom4live.singtocloud.core.mediatype.MediaType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension
import java.io.File

@ExtendWith(MockitoExtension::class)
internal class Mp3MediaTypeDetectorTest {

    @InjectMocks
    private lateinit var detector: Mp3MediaTypeDetector


    @Test
    fun detectTextFileReturnsNull() {
        //arrange
        val textFileURL = this.javaClass.classLoader.getResource("text.txt")
        val textFile = File(textFileURL!!.toURI())

        //act
        val result = detector.detect(textFile)

        //assert
        Assertions.assertNull(result)
    }

    @Test
    fun detectMp3FileReturnsMp3MediaType() {
        //arrange
        val mp3FileURL = this.javaClass.classLoader.getResource("mp3_sample.mp3")
        val mp3File = File(mp3FileURL!!.toURI())

        //act
        val result = detector.detect(mp3File)

        //assert
        Assertions.assertEquals(MediaType.MP3, result)
    }

}
