package me.freedom4live.singtocloud.application.frontend.javafx.impl.config

import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import me.freedom4live.singtocloud.application.frontend.javafx.impl.annotation.FxStage
import me.freedom4live.singtocloud.application.frontend.javafx.impl.stages.AbstractFxStage
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.util.ResourceUtils

internal class FxStageBeanPostProcessor : BeanPostProcessor {

    private val CLASSPATH_PREFIX = "classpath:"

    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any? = when (bean) {
        is AbstractFxStage -> processFxAnnotation(bean)
        else -> bean
    }

    private fun processFxAnnotation(bean: AbstractFxStage): AbstractFxStage =
            when (val fxAnnotation = bean.javaClass.getAnnotation(FxStage::class.java)) {
                null -> bean
                else -> processFxAnnotationInternal(bean, fxAnnotation)
            }

    private fun processFxAnnotationInternal(bean: AbstractFxStage, fxAnnotation: FxStage): AbstractFxStage = bean.run {
        val filePath = fxAnnotation.fxmlFile
        ResourceUtils.getURL("$CLASSPATH_PREFIX$filePath").let { fxmlUrl ->
            val loadedParent = FXMLLoader().apply {
                setController(bean)
                location = fxmlUrl
            }.run { load<Parent>() }

            stage = loadedParent
            return this
        }
    }

}
