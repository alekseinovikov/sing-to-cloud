package me.freedom4live.singtocloud.core.mediatype

import java.io.File

internal abstract class AbstractMediaTypeDetector(var nextDetector: AbstractMediaTypeDetector? = null) {

    fun detect(file: File): MediaType? {
        return when (val detectedMediaType = detectInternal(file)) {
            null -> detectNext(file)
            else -> detectedMediaType
        }
    }

    private fun detectNext(file: File) = nextDetector?.detect(file)

    protected abstract fun detectInternal(file: File): MediaType?

}
