package me.freedom4live.singtocloud.translation.translator.impl

import me.freedom4live.singtocloud.translation.Language
import me.freedom4live.singtocloud.translation.TitlePlaceHolders
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class TranslatorImplTest {

    @InjectMocks
    private lateinit var translator: TranslatorImpl

    @Test
    fun resolve_englishFileSystemSource_englishValue() {
        //arrange
        val placeHolder = TitlePlaceHolders.Source.FILE_SYSTEM
        val language = Language.ENG

        //act
        val result = translator.resolve(placeHolder, language)

        //assert
        assertThat(result).isEqualTo("Local File System")
    }

}
