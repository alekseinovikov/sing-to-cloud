package me.freedom4live.singtocloud.source.filesystem

import me.freedom4live.singtocloud.source.api.TrackSourceType
import me.freedom4live.singtocloud.source.filesystem.reader.ContentReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

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
}