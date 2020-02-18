package me.freedom4live.singtocloud.application.fx.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "application.window")
internal class FxWindowProperties {

    var title: String? = null

    var width: Double? = null

    var height: Double? = null

    var isResizable: Boolean = true

    var isCentralizedOnScreen: Boolean = true

}