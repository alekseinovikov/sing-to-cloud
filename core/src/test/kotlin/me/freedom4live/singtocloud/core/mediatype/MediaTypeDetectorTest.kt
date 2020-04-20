package me.freedom4live.singtocloud.core.mediatype

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import java.io.File

internal class MediaTypeDetectorTest {

    @Test
    fun detectMp3FileReturnsMp3MediaType() {
        //arrange
        val mp3FileURL = this.javaClass.classLoader.getResource("mp3_sample.mp3")
        val file = File(mp3FileURL!!.toURI())

        //act
        val result = MediaTypeDetector.detect(file)

        //assert
        Assertions.assertEquals(MediaType.MP3, result)
    }

    @Test
    fun detectTxtFileReturnsTxtMediaType() {
        //arrange
        val txtFileURL = this.javaClass.classLoader.getResource("text.txt")
        val file = File(txtFileURL!!.toURI())

        //act
        val result = MediaTypeDetector.detect(file)

        //assert
        Assertions.assertEquals(MediaType.TXT, result)
    }

    @Test
    fun detectZipFileReturnsUnknownMediaType() {
        //arrange
        val zipFileURL = this.javaClass.classLoader.getResource("text.txt.zip")
        val file = File(zipFileURL!!.toURI())

        //act
        val result = MediaTypeDetector.detect(file)

        //assert
        Assertions.assertEquals(MediaType.UNKNOWN, result)
    }

}
