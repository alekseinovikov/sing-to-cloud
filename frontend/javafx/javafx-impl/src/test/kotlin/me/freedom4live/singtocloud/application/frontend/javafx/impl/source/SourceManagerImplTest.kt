package me.freedom4live.singtocloud.application.frontend.javafx.impl.source

import me.freedom4live.singtocloud.source.api.TrackSource
import me.freedom4live.singtocloud.source.api.TrackSourceType
import me.freedom4live.singtocloud.translation.TitlePlaceHolders
import me.freedom4live.singtocloud.translation.translator.Translator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

internal class SourceManagerImplTest {

    private lateinit var trackSources: MutableList<TrackSource>
    private lateinit var translator: Translator
    private lateinit var sourceManager: SourceManagerImpl

    @BeforeEach
    fun setUp() {
        this.translator = mock(Translator::class.java)
        this.trackSources = mutableListOf()
        this.sourceManager = SourceManagerImpl(this.trackSources, translator)
    }

    @Test
    fun supports_injectedNoneImpls_returnsEmptyList() {
        //act
        val result = sourceManager.supports()

        //assert
        assertThat(result).isEmpty()
    }

    @Test
    fun supports_injectedOneImpl_returnsItsSupports() {
        //arrange
        val trackSource = mock(TrackSource::class.java)
        `when`(trackSource.supports()).thenReturn(TrackSourceType.FILESYSTEM)

        this.trackSources.add(trackSource)

        //act
        val result = sourceManager.supports()

        //assert
        assertThat(result)
                .isNotEmpty
                .hasSize(1)
                .containsExactly(TrackSourceType.FILESYSTEM)
    }

    @Test
    fun getTitle_fileSystem_returnsWhatTranslatorReturns() {
        //arrange
        val trackSourceType = TrackSourceType.FILESYSTEM

        `when`(translator.resolve(TitlePlaceHolders.Source.FILE_SYSTEM)).thenReturn("RESULT")

        //act
        val result = sourceManager.getTitle(trackSourceType)

        //assert
        verify(translator).resolve(TitlePlaceHolders.Source.FILE_SYSTEM)
        assertThat(result).isEqualTo("RESULT")
    }

}
