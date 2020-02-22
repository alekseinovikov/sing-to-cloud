package me.freedom4live.singtocloud.source.filesystem.helpers

import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

object FileHelper {

    fun getDirectory(pathString: String): File {
        val path = Paths.get(pathString)
        return when (Files.isDirectory(path)) {
            false -> throw IllegalArgumentException("$pathString is not a directory!")
            true -> File(path.toUri())
        }
    }

}
