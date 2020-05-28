package me.freedom4live.singtocloud.core.config

import me.freedom4live.singtocloud.core.CorePackageScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@ComponentScan(basePackageClasses = [CorePackageScan::class])
@Configuration
internal class CoreConfiguration {
}