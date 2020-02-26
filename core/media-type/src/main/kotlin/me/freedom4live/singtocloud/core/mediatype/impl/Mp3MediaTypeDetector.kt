package me.freedom4live.singtocloud.core.mediatype.impl

import me.freedom4live.singtocloud.core.mediatype.MediaType

internal class Mp3MediaTypeDetector : TikaMediaTypeDetector("audio/mpeg", MediaType.MP3)
