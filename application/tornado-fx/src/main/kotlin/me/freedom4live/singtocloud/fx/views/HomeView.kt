package me.freedom4live.singtocloud.fx.views

import tornadofx.View
import tornadofx.label
import tornadofx.vbox

class HomeView : View("Home") {
    override val root = vbox {
        label { text = "Hello to Sing To Cloud Application!" }
    }
}
