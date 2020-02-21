package me.freedom4live.singtocloud.source.api.model

sealed class TrackRequest

data class FileSystemTrackRequest(val dirPath: String) : TrackRequest()