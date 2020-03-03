dependencies {
    implementation(project(":core:media-type"))

    implementation("org.apache.tika:tika-parsers:${project.extra["apacheTikaVersion"]}")
}
