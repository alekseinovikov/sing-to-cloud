package me.freedom4live.singtocloud.translation.translator.impl

import me.freedom4live.singtocloud.translation.Language
import me.freedom4live.singtocloud.translation.TitlePlaceHolder
import me.freedom4live.singtocloud.translation.translator.Translator

internal class TranslatorImpl : Translator {

    override fun resolve(placeholder: TitlePlaceHolder, language: Language) = Translations.languageTranslations[language]?.let { it.translate(placeholder) }
            ?: throw IllegalStateException("Language $language is not found!")

}
