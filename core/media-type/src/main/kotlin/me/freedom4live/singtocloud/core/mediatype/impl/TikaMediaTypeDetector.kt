package me.freedom4live.singtocloud.core.mediatype.impl

import me.freedom4live.singtocloud.core.mediatype.AbstractMediaTypeDetector
import me.freedom4live.singtocloud.core.mediatype.MediaType
import org.apache.tika.Tika
import java.io.File

private val tika = Tika()

internal abstract class TikaMediaTypeDetector(private val mimeTypeString: String,
                                              private val mediaType: MediaType) : AbstractMediaTypeDetector() {

    override fun detectInternal(file: File) = when (getMediaTypeString(file)) {
        mimeTypeString -> mediaType
        else -> null
    }

    private fun getMediaTypeString(file: File) = tika.detect(file)

}
