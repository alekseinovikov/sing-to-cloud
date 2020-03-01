package me.freedom4live.singtocloud.source.api.model

import me.freedom4live.singtocloud.id.Id

sealed class FileInfo(val fileName: String)
data class FileSystemFileInfo(val name: String, val filePath: String) : FileInfo(name)

data class TrackMetaData(val title: String?,
                         val artist: String?,
                         val album: String?,
                         val genre: String?,
                         val creator: String?)

data class TrackResponse(val id: Id,
                         val metaData: TrackMetaData?,
                         val fileInfo: FileInfo)
