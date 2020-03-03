plugins {
    id("org.openjfx.javafxplugin")
}

javafx {
    version = project.extra["javaFXVersion"].toString()
    modules = listOf("javafx.web", "javafx.fxml")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("no.tornado:tornadofx:${project.extra["tornadoFXVersion"]}")

    api(project(":frontend:javafx:javafx-api"))
    api(project(":cloud-integration:spotify:spotify-api"))
    api(project(":source:source-api"))
}
