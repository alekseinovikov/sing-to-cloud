plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.openjfx.javafxplugin")
}

javafx {
    version = project.extra["javaFXVersion"].toString()
    modules = arrayListOf("javafx.controls", "javafx.graphics")
}

dependencies {
    implementation(project(":core"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("no.tornado:tornadofx:${project.extra["tornadoFXVersion"]}")
}
