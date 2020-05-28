package me.freedom4live.singtocloud.core.source

interface SourceProvider {
    fun getAllSupportedSources(): List<SourceData>
}