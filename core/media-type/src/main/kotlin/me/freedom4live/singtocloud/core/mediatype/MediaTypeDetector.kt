package me.freedom4live.singtocloud.core.mediatype

import me.freedom4live.singtocloud.core.mediatype.impl.Mp3MediaTypeDetector
import me.freedom4live.singtocloud.core.mediatype.impl.TxtMediaTypeDetector
import java.io.File

object MediaTypeDetector {

    private val mp3Detector = Mp3MediaTypeDetector()
    private val txtDetector = TxtMediaTypeDetector()

    private var rootDetector: AbstractMediaTypeDetector
    private var tailDetector: AbstractMediaTypeDetector

    init {
        rootDetector = mp3Detector

        mp3Detector.nextDetector = txtDetector

        tailDetector = txtDetector
    }

    fun detect(file: File): MediaType = when (val mediaType = rootDetector.detect(file)) {
        null -> MediaType.UNKNOWN
        else ->
            mediaType
    }
}
