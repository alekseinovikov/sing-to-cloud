dependencies {
    implementation("org.apache.tika:tika-core:${project.extra["apacheTikaVersion"]}")
    implementation("org.apache.tika:tika-parsers:${project.extra["apacheTikaVersion"]}")
    implementation("org.springframework.boot:spring-boot-starter")
}
