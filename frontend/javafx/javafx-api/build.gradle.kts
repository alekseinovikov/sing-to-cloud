plugins {
    id("org.openjfx.javafxplugin")
}

dependencies {
    implementation("no.tornado:tornadofx:${project.extra["tornadoFXVersion"]}")
}

javafx {
    version = "11.0.2"
    modules = listOf("javafx.web", "javafx.fxml")
}