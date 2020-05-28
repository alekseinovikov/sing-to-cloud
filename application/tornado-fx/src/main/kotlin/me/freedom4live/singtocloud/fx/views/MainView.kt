package me.freedom4live.singtocloud.fx.views

import me.freedom4live.singtocloud.core.source.SourceProvider
import me.freedom4live.singtocloud.core.source.TrackSource
import tornadofx.*

class MainView : View("Choose music source") {

    private val sourceProvider: SourceProvider by di()

    override val root = vbox {
        label { text = "Choose music source:" }

        getSourceButtons().forEach { sourceData ->
            button(sourceData.title) { action { onSourceButtonClick(sourceData.source) } }
        }
    }

    private fun getSourceButtons() = sourceProvider.getAllSupportedSources()

    private fun onSourceButtonClick(source: TrackSource) {
        println("Clicked $source")
    }

}
