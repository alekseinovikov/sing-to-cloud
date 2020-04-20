package me.freedom4live.singtocloud.core.metadata.finder

import me.freedom4live.singtocloud.core.mediatype.MediaType
import me.freedom4live.singtocloud.core.track.info.finder.Mp3TrackInfoFinder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import java.io.File

internal class Mp3TrackInfoFinderTest {

    @Test
    fun supportsReturnsMp3() {
        //act
        val result = Mp3TrackInfoFinder.supports()

        //assert
        Assertions.assertEquals(MediaType.MP3, result)
    }

    @Test
    fun findHasFile() {
        //arrange
        val fileURL = this.javaClass.classLoader.getResource("mp3_sample.mp3")
        val mp3File = File(fileURL.toURI())

        //act
        val result = Mp3TrackInfoFinder.find(mp3File)

        //assert
        Assertions.assertEquals("Cinematic", result.genre)
        Assertions.assertEquals("YouTube Audio Library", result.album)
        Assertions.assertEquals("Kevin MacLeod", result.artist)
        Assertions.assertEquals("Impact Moderato", result.title)
        Assertions.assertEquals("Kevin MacLeod", result.creator)
    }

}
