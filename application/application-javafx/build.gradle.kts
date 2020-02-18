plugins {
    id("org.springframework.boot")
    id("org.openjfx.javafxplugin")
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")

    api(project(":frontend:javafx:javafx-api"))

    implementation(project(":frontend:javafx:javafx-impl"))
    implementation(project(":cloud-integration:spotify:spotify-impl"))

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

javafx {
    version = "11.0.2"
    modules = listOf("javafx.web", "javafx.fxml")
}

tasks.bootJar {
    enabled = true
}