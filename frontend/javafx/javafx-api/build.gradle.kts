plugins {
    id("org.openjfx.javafxplugin")
}

javafx {
    version = project.extra["javaFXVersion"].toString()
    modules = listOf("javafx.web", "javafx.fxml")
}

dependencies {
    implementation("no.tornado:tornadofx:${project.extra["tornadoFXVersion"]}")
}