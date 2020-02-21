package me.freedom4live.singtocloud.source.api.model

typealias TrackId = Long

sealed class FileInfo(val fileName: String)
data class FileSystemFileInfo(val name: String, val filePath: String) : FileInfo(name)

data class TrackMetaData(val title: String?,
                         val artist: String?,
                         val album: String?,
                         val year: Int?,
                         val comment: String?)

data class TrackResponse(val id: TrackId,
                         val metaData: TrackMetaData?,
                         val fileInfo: FileInfo)