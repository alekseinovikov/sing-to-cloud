package me.freedom4live.singtocloud.application.fx.view

import tornadofx.View
import tornadofx.button
import tornadofx.label
import tornadofx.vbox

internal class MainView : View() {
    override val root = vbox {
        label("Welcome to SingToCloud!")
        button("START")
    }
}