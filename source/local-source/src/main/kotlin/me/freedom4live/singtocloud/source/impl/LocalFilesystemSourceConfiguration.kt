package me.freedom4live.singtocloud.source.impl

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LocalFilesystemSourceConfiguration {

    @Bean
    fun localFileSystemSource() = LocalFilesystemTrackSource()

}
