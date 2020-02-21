package me.freedom4live.singtocloud.source.filesystem

import me.freedom4live.singtocloud.source.filesystem.reader.ContentReader
import me.freedom4live.singtocloud.source.filesystem.reader.impl.ContentReaderImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class LocalFilesystemSourceConfiguration {

    @Bean
    fun contentReader() = ContentReaderImpl()

    @Bean
    fun localFileSystemSource(contentReader: ContentReader) = LocalFilesystemTrackSource(contentReader)

}
