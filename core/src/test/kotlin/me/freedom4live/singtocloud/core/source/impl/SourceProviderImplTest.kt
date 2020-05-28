package me.freedom4live.singtocloud.core.source.impl

import me.freedom4live.singtocloud.core.source.SourceData
import me.freedom4live.singtocloud.core.source.TrackSource
import me.freedom4live.singtocloud.core.translate.Translator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class SourceProviderImplTest {

    @InjectMocks
    private lateinit var sourceProvider: SourceProviderImpl

    @Mock
    private lateinit var translator: Translator


    @Test
    fun getAllSupportedSources_allEnumValues_translatorReturnsValues() {
        //arrange
        `when`(translator.getTranslation(anyString())).thenAnswer { it.arguments[0] }

        //act
        val result = sourceProvider.getAllSupportedSources()

        //assert
        val allSources = TrackSource.values().map { SourceData(it, it.name) }.toList()
        assertThat(result).containsSequence(allSources)
    }

    @Test
    fun getAllSupportedSources_allEnumValues_translatorReturnsNulls() {
        //arrange
        `when`(translator.getTranslation(anyString())).thenAnswer { null }

        //act
        val result = sourceProvider.getAllSupportedSources()

        //assert
        val allSources = TrackSource.values().map { SourceData(it, it.name) }.toList()
        assertThat(result).containsSequence(allSources)
    }

}