package me.freedom4live.singtocloud.source.filesystem.helpers

import java.io.File
import java.nio.file.Files
import java.nio.file.Path

object FileHelper {

    fun getDirectory(pathString: String): File {
        val path = Path.of(pathString)
        return when (Files.isDirectory(path)) {
            false -> throw IllegalArgumentException("$pathString is not a directory!")
            true -> File(path.toUri())
        }
    }

}