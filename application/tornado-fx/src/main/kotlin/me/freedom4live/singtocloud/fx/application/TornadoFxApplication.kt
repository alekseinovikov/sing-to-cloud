package me.freedom4live.singtocloud.fx.application

import me.freedom4live.singtocloud.fx.views.HomeView
import tornadofx.App
import tornadofx.launch

class TornadoFxApplication : App(HomeView::class)

fun main(args: Array<String>) {
    launch<TornadoFxApplication>()
}
