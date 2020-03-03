plugins {
    id("org.springframework.boot")
    id("org.openjfx.javafxplugin")
}

javafx {
    version = project.extra["javaFXVersion"].toString()
    modules = listOf("javafx.web", "javafx.fxml")
}

tasks.bootJar {
    enabled = true
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("no.tornado:tornadofx:${project.extra["tornadoFXVersion"]}")

    api(project(":frontend:javafx:javafx-api"))

    implementation(project(":frontend:javafx:javafx-impl"))
    implementation(project(":cloud-integration:spotify:spotify-impl"))
    implementation(project(":source:local-source"))

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}
