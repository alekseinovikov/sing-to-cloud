import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.5.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("jvm") version "1.3.70"
    kotlin("plugin.spring") version "1.3.70"
    id("org.openjfx.javafxplugin") version "0.0.8"
}

allprojects {
    extra["tornadoFXVersion"] = "1.7.20"
    extra["apacheTikaVersion"] = "1.23"
    extra["javaFXVersion"] = "11.0.2"

    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")

    repositories {
        mavenCentral()
    }

    group = "me.freedom4live.singtocloud"
    version = "0.0.1-SNAPSHOT"
    java.sourceCompatibility = JavaVersion.VERSION_1_8

    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.2.5.RELEASE")
        }
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.springframework.boot:spring-boot-configuration-processor")

        testImplementation("org.junit.jupiter:junit-jupiter")
        testImplementation("org.mockito:mockito-junit-jupiter")
    }


    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "12"
        }
    }
}

tasks.bootJar {
    enabled = false
}