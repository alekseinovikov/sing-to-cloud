plugins {
    id("org.openjfx.javafxplugin")
}

javafx {
    version = "11.0.2"
    modules = listOf("javafx.web", "javafx.fxml")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")

    api(project(":frontend:javafx:javafx-api"))
    api(project(":cloud-integration:spotify:spotify-api"))
}