package me.freedom4live.singtocloud.application.frontend.javafx.impl.stages

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import me.freedom4live.singtocloud.application.frontend.javafx.impl.annotation.FxStage
import javax.annotation.PostConstruct

@FxStage("stages/main.fxml")
internal class MainStage : AbstractFxStage() {

    @FXML
    private lateinit var label: Label
    @FXML
    private lateinit var button: Button

    @PostConstruct
    fun init() {
        var counter = 0
        button.setOnMouseClicked { label.text = "Counter: ${counter++}" }
    }

}
