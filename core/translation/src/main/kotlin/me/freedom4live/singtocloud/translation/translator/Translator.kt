package me.freedom4live.singtocloud.translation.translator

import me.freedom4live.singtocloud.translation.Language
import me.freedom4live.singtocloud.translation.TitlePlaceHolder

interface Translator {

    fun resolve(placeholder: TitlePlaceHolder, language: Language = Language.ENG): String

}
