package me.freedom4live.singtocloud.core.metadata

import me.freedom4live.singtocloud.core.track.info.TrackInfoExtractor
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

internal class TrackInfoExtractorTest {

    @Test
    fun extractTxtFileNull() {
        //arrange
        val fileURL = this.javaClass.classLoader.getResource("text.txt")!!
        val textFile = File(fileURL.toURI())

        //act
        val result = TrackInfoExtractor.extract(textFile)

        //assert
        Assertions.assertNull(result)
    }

    @Test
    fun extractMp3FileResultHasMetadata() {
        //arrange
        val fileURL = this.javaClass.classLoader.getResource("mp3_sample.mp3")!!
        val mp3File = File(fileURL.toURI())

        //act
        val result = TrackInfoExtractor.extract(mp3File) ?: throw IllegalStateException("result must not be null!")

        //assert
        Assertions.assertEquals("Cinematic", result.genre)
        Assertions.assertEquals("YouTube Audio Library", result.album)
        Assertions.assertEquals("Kevin MacLeod", result.artist)
        Assertions.assertEquals("Impact Moderato", result.title)
        Assertions.assertEquals("Kevin MacLeod", result.creator)
    }

}
