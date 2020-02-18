package me.freedom4live.singtocloud.frontend.javafx.impl

import javafx.stage.Window
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class SceneManagerImplTest {

    @InjectMocks
    private lateinit var sceneManager: SceneManagerImpl

    @Test
    fun initPassingWindowNoException() {
        //arrange
        val window = Mockito.mock(Window::class.java)

        //act
        sceneManager.init(window)
    }

}