package me.freedom4live.singtocloud.application.frontend.javafx.impl.stages.source

import me.freedom4live.singtocloud.application.frontend.javafx.impl.annotation.FxStage
import me.freedom4live.singtocloud.source.api.SourceType

@FxStage("stages/LocalStorage.fxml")
internal class LocalStorageStage : SourceStage() {
    override fun supports() = SourceType.LOCAL_FILESYSTEM

}
