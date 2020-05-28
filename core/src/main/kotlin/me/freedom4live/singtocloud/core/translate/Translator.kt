package me.freedom4live.singtocloud.core.translate

interface Translator {
    fun getTranslation(placeholder: String): String?
}