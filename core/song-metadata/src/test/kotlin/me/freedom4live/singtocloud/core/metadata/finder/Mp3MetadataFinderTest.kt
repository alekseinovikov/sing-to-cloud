package me.freedom4live.singtocloud.core.metadata.finder

import me.freedom4live.singtocloud.core.mediatype.MediaType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Mp3MetadataFinderTest {

    @Test
    fun supportsReturnsMp3() {
        //act
        val result = Mp3MetadataFinder.supports()

        //assert
        Assertions.assertEquals(MediaType.MP3, result)
    }

    @Test
    fun findHasFile() {
        val fileURL = this.javaClass.classLoader.getResource("mp3_sample.mp3")
        val mp3File = File(fileURL.toURI())

        Mp3MetadataFinder.find(mp3File)
    }
}
