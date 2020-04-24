plugins {
    id("application")
    id("org.openjfx.javafxplugin")
}

javafx {
    version = project.extra["javaFXVersion"].toString()
    modules = arrayListOf("javafx.controls", "javafx.graphics")
}

dependencies {
    implementation(project(":core"))
    implementation("no.tornado:tornadofx:${project.extra["tornadoFXVersion"]}")
}

application {
    mainClassName = "me.freedom4live.singtocloud.fx.application.TornadoFxApplicationKt"
}
