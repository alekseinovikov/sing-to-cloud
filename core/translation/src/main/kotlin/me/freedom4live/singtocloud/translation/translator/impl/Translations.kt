package me.freedom4live.singtocloud.translation.translator.impl

import me.freedom4live.singtocloud.translation.Language
import me.freedom4live.singtocloud.translation.TitlePlaceHolder
import me.freedom4live.singtocloud.translation.TitlePlaceHolders

internal interface LanguageTranslation {
    fun translate(placeholder: TitlePlaceHolder): String
}

internal object Translations {
    val languageTranslations = mapOf(Language.ENG to EnglishTranslations)
}

internal object EnglishTranslations : LanguageTranslation {

    private val valueMap = mapOf(TitlePlaceHolders.Source.FILE_SYSTEM to "Local File System")

    override fun translate(placeholder: TitlePlaceHolder): String = valueMap[placeholder]
            ?: throw IllegalStateException("Can't find value: $placeholder for English Language!")

}
