dependencies {
    api(project(":cloud-integration:spotify:spotify-api"))

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("se.michaelthelin.spotify:spotify-web-api-java:4.2.1")
}