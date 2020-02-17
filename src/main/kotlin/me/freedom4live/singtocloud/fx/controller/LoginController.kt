package me.freedom4live.singtocloud.fx.controller

import javafx.scene.Parent
import javafx.scene.layout.StackPane
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class LoginController {

    lateinit var rootView: Parent

    @PostConstruct
    fun  init() {
        rootView = StackPane()
    }

}
