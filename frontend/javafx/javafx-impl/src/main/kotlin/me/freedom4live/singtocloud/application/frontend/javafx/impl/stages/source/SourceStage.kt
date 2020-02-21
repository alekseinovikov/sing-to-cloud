package me.freedom4live.singtocloud.application.frontend.javafx.impl.stages.source

import me.freedom4live.singtocloud.application.frontend.javafx.impl.stages.AbstractFxStage
import me.freedom4live.singtocloud.source.api.TrackSourceType

internal abstract class SourceStage: AbstractFxStage() {
    abstract fun supports(): TrackSourceType
}
