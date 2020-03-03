package me.freedom4live.singtocloud.application.fx

import me.freedom4live.singtocloud.application.fx.view.MainView
import tornadofx.App
import tornadofx.launch

internal class JavaFxApplication : App(MainView::class)

fun main(args: Array<String>) {
    launch<JavaFxApplication>(args)
}
